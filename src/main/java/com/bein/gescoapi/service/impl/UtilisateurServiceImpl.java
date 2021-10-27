package com.bein.gescoapi.service.impl;

import com.bein.gescoapi.dao.InstitutionRepository;
import com.bein.gescoapi.dao.UtilisateurRepository;
import com.bein.gescoapi.dto.UserPasswordResetRequestPayload;
import com.bein.gescoapi.dto.UtilisateurRequestDto;
import com.bein.gescoapi.dto.UtilisateurResponseDto;
import com.bein.gescoapi.entities.Institution;
import com.bein.gescoapi.entities.Utilisateur;
import com.bein.gescoapi.exception.NotIdenticPasswordExecption;
import com.bein.gescoapi.mapper.UtilisateurMapper;
import com.bein.gescoapi.service.declaration.UtilisateurService;
import com.bein.gescoapi.utils.ShaHash;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService, UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;
    private final InstitutionRepository institutionRepository;
    private final ShaHash shaHash;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, InstitutionRepository institutionRepository, ShaHash shaHash) {
        this.utilisateurRepository = utilisateurRepository;
        this.institutionRepository = institutionRepository;
        this.shaHash = shaHash;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = utilisateurRepository.findByLogin(username).get();
        if (user == null) {
            log.error("user not found in the database");
            throw new UsernameNotFoundException("user not found in the database");
        } else {
            log.info("User found in the database {}", username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), authorities);
    }

    @Override
    public List<UtilisateurResponseDto> getAllByIdinstitution(Integer id) {
        return utilisateurRepository.findAllByIdinstitution(id)
                .stream().map(UtilisateurMapper.INSTANCE::fromEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UtilisateurResponseDto saveUser(UtilisateurRequestDto utilisateurRequestDto) {

        if (utilisateurRequestDto.getPassword().equals(utilisateurRequestDto.getRepeatPassword())) {
            Optional<Institution> i = institutionRepository.findById(utilisateurRequestDto.getInstitution());
            if (i.isPresent()) {
                Utilisateur utilisateur = UtilisateurMapper.INSTANCE.fromRequestToEntity(utilisateurRequestDto);
                utilisateur.setIdinstitution(i.get());
                utilisateur.setIdutilisateur(this.nextId());
                utilisateur.setPassword(shaHash.hash(utilisateur.getPassword()));
                utilisateur.setEtat(true);
                utilisateur.setDatecreation(Date.from(Instant.now()));
                utilisateur.setPhoto("avatar.jpeg");
                utilisateur.setPrincipal(utilisateurRepository.findAllByIdinstitution(utilisateurRequestDto.getInstitution()).isEmpty());
                Utilisateur u = utilisateurRepository.save(utilisateur);

                return UtilisateurMapper.INSTANCE.fromEntityToResponse(u);
            }
        }
        return null;
    }

    @Override
    public UtilisateurResponseDto editUser(UtilisateurRequestDto utilisateurRequestDto) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(utilisateurRequestDto.getIdutilisateur().intValue());
        if (utilisateur.isPresent()) {
            Utilisateur u = utilisateur.get();
            u.setNom(utilisateurRequestDto.getNom());
            u.setPrenom(utilisateurRequestDto.getPrenom());
            u.setLogin(utilisateurRequestDto.getLogin());
            u = utilisateurRepository.save(u);

            return UtilisateurMapper.INSTANCE.fromEntityToResponse(u);
        }
        throw new UsernameNotFoundException("user not found with usename : " + utilisateurRequestDto.getLogin());
    }

    @Override
    public void resetPassword(String username) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByLogin(username);
        if (!utilisateur.isPresent()) {
            throw new UsernameNotFoundException("user not found with usename : " + username);
        }
        Utilisateur u = utilisateur.get();
        u.setPassword(shaHash.hash("123456"));
        utilisateurRepository.save(u);
    }

    @Override
    public void changePassword(UserPasswordResetRequestPayload requestPayload) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByLogin(requestPayload.getUsername());
        if (!utilisateur.isPresent()) {
            throw new UsernameNotFoundException("user not found with usename : " + requestPayload.getUsername());
        }
        Utilisateur u = utilisateur.get();
        if (!u.getPassword().equals(shaHash.hash(requestPayload.getOldPassword()))) {
            throw new NotIdenticPasswordExecption("L'ancien mot de passe est incorrect");
        }
        if (!requestPayload.getNewPassword().equals(requestPayload.getRepeatNewPassword())) {
            throw new NotIdenticPasswordExecption("Les deux nouveaux mot de passe ne sont pas identiques");
        }
        u.setPassword(shaHash.hash(requestPayload.getNewPassword()));
        utilisateurRepository.save(u);
    }

    private Long nextId() {
        try {
            return this.utilisateurRepository.nextId() + 1;
        } catch (Exception e) {
            return 1l;
        }
    }
}

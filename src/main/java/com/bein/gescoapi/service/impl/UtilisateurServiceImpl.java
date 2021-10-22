package com.bein.gescoapi.service.impl;

import com.bein.gescoapi.dao.UtilisateurRepository;
import com.bein.gescoapi.entities.Utilisateur;
import com.bein.gescoapi.service.declaration.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService, UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
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
}

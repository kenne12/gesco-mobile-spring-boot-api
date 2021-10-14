package com.bein.gescoapi.service.impl;

import com.bein.gescoapi.dao.EleveRepository;
import com.bein.gescoapi.dao.InscriptionRepository;
import com.bein.gescoapi.dto.InscriptionResponseDto;
import com.bein.gescoapi.entities.Inscription;
import com.bein.gescoapi.mapper.ClasseMapper;
import com.bein.gescoapi.mapper.EleveMapper;
import com.bein.gescoapi.mapper.InscriptionMapper;
import com.bein.gescoapi.service.declaration.InscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;
    private final EleveRepository eleveRepository;

    @Override
    public List<InscriptionResponseDto> getAllActiveInscriptionByClasse(int idAnnee, int idClasse, int idInstitution) {

        List<Inscription> inscriptions = inscriptionRepository.findInscriptionByIdanneescolaireAndIdclasseEleveActif(idAnnee, idClasse, idInstitution, true);
        return this.initResponse(inscriptions);
    }

    @Override
    public List<InscriptionResponseDto> getAllInscriptionByClasse(int idAnnee, int idClasse, int idInstitution) {

        List<Inscription> inscriptions = inscriptionRepository.findInscriptionByIdanneescolaireAndIdclasseEleve(idAnnee, idClasse, idInstitution);
        return this.initResponse(inscriptions);
    }

    private List<InscriptionResponseDto> initResponse(List<Inscription> inscriptions) {
        return inscriptions.stream().map(i -> {
            InscriptionResponseDto irsp = InscriptionMapper.INSTANCE.fromEntityToResponse(i);
            irsp.setClasse(ClasseMapper.INSTANCE.fromEntityToResponse(i.getIdclasse()));
            //irsp.setAnneescolaire(AnneeMapper.INSTANCE.fromEntityToResponse(i.getIdanneescolaire()));
            irsp.setEleve(EleveMapper.INSTANCE.fromEntityToDto(i.getIdeleve()));
            return irsp;
        }).collect(Collectors.toList());
    }
}

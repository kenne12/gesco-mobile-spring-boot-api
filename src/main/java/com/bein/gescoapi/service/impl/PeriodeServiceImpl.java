package com.bein.gescoapi.service.impl;

import com.bein.gescoapi.dao.AnneeScolaireRepository;
import com.bein.gescoapi.dao.PeriodeRepository;
import com.bein.gescoapi.dao.SequenceRepository;
import com.bein.gescoapi.dao.TrimestreRepository;
import com.bein.gescoapi.dto.AnneeResponseDto;
import com.bein.gescoapi.dto.PeriodeResponseDto;
import com.bein.gescoapi.entities.Anneescolaire;
import com.bein.gescoapi.mapper.AnneeMapper;
import com.bein.gescoapi.mapper.PeriodeMapper;
import com.bein.gescoapi.mapper.SequenceMapper;
import com.bein.gescoapi.mapper.TrimestreMapper;
import com.bein.gescoapi.service.declaration.PeriodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PeriodeServiceImpl implements PeriodeService {

    private final AnneeScolaireRepository anneeScolaireRepository;
    private final SequenceRepository sequenceRepository;
    private final TrimestreRepository trimestreRepository;
    private final PeriodeRepository periodeRepository;

    @Override
    public List<AnneeResponseDto> findAllAnneeScolaire() {
        return anneeScolaireRepository.getAllAnnee()
                .stream()
                .map(AnneeMapper.INSTANCE::fromEntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PeriodeResponseDto> findAllTrimestreByIdanne(Integer idAnnee) {

        return periodeRepository.findAllTrimestreByIdannee(idAnnee)
                .stream().map(p -> {
                    PeriodeResponseDto pTemp = PeriodeMapper.INSTANCE.fromEntityToResponse(p);
                    pTemp.setAnnee(AnneeMapper.INSTANCE.fromEntityToResponse(p.getIdanneescolaire()));
                    pTemp.setTrimestre(TrimestreMapper.INSTANCE.fromEntityToResponse(p.getIdTrimestre()));
                    return pTemp;
                }).collect(Collectors.toList());
    }

    @Override
    public List<PeriodeResponseDto> findAllSequenceByIdanne(Integer idAnnee) {
        return periodeRepository.findAllSequenceByIdannee(idAnnee)
                .stream().map(p -> {
                    PeriodeResponseDto pTemp = PeriodeMapper.INSTANCE.fromEntityToResponse(p);
                    pTemp.setAnnee(AnneeMapper.INSTANCE.fromEntityToResponse(p.getIdanneescolaire()));
                    pTemp.setTrimestre(TrimestreMapper.INSTANCE.fromEntityToResponse(p.getIdTrimestre()));
                    pTemp.setSequence(SequenceMapper.INSTANCE.fromEntityToResponse(p.getIdsequence()));
                    return pTemp;
                }).collect(Collectors.toList());
    }
}

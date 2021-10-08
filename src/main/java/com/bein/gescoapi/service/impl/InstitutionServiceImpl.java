package com.bein.gescoapi.service.impl;

import com.bein.gescoapi.dao.ClasseRepository;
import com.bein.gescoapi.dto.ClasseResponseDto;
import com.bein.gescoapi.mapper.ClasseMapper;
import com.bein.gescoapi.mapper.GroupeMapper;
import com.bein.gescoapi.mapper.NiveauClasseMapper;
import com.bein.gescoapi.service.declaration.InstitutionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstitutionServiceImpl implements InstitutionService {

    private final ClasseRepository classeRepository;

    @Override
    public List<ClasseResponseDto> findAllClasse() {
        return classeRepository.findAllClasse()
                .stream().map(c -> {
                    ClasseResponseDto cTemp = ClasseMapper.INSTANCE.fromEntityToResponse(c);
                    cTemp.setGroupe(GroupeMapper.INSTANCE.fromEntityToResponse(c.getIdgroupe()));
                    cTemp.setNiveauclasse(NiveauClasseMapper.INSTANCE.fromEntityToResponse(c.getIdniveauclasse()));
                    return cTemp;
                }).collect(Collectors.toList());
    }
}

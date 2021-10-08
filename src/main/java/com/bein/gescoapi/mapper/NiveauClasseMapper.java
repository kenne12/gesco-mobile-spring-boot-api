package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.NIveauClasseResponseDto;
import com.bein.gescoapi.entities.Niveauclasse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NiveauClasseMapper {
    NiveauClasseMapper INSTANCE = Mappers.getMapper(NiveauClasseMapper.class);

    NIveauClasseResponseDto fromEntityToResponse(Niveauclasse niveauclasse);
}

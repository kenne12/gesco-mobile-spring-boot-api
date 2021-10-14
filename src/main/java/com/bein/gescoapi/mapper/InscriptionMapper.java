package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.InscriptionResponseDto;
import com.bein.gescoapi.entities.Inscription;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InscriptionMapper {

    InscriptionMapper INSTANCE = Mappers.getMapper(InscriptionMapper.class);

    InscriptionResponseDto fromEntityToResponse(Inscription inscription);
}

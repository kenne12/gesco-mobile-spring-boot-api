package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.EleveResponseDto;
import com.bein.gescoapi.entities.Eleve;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EleveMapper {
    EleveMapper INSTANCE = Mappers.getMapper(EleveMapper.class);

    EleveResponseDto fromEntityToDto(Eleve eleve);
}

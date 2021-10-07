package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.AnneeResponseDto;
import com.bein.gescoapi.entities.Anneescolaire;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AnneeMapper {
    AnneeMapper INSTANCE = Mappers.getMapper(AnneeMapper.class);

    AnneeResponseDto fromEntityToResponse(Anneescolaire anneescolaire);
}

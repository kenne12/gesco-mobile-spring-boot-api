package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.TrimestreResponseDto;
import com.bein.gescoapi.entities.Trimestre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TrimestreMapper {
    TrimestreMapper INSTANCE = Mappers.getMapper(TrimestreMapper.class);

    TrimestreResponseDto fromEntityToResponse(Trimestre trimestre);
}

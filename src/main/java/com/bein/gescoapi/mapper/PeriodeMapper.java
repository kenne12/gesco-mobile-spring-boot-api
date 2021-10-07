package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.PeriodeResponseDto;
import com.bein.gescoapi.entities.Periode;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PeriodeMapper {
    PeriodeMapper INSTANCE = Mappers.getMapper(PeriodeMapper.class);

    PeriodeResponseDto fromEntityToResponse(Periode periode);
}

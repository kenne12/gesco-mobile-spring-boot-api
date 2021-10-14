package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.MatiereResponseDto;
import com.bein.gescoapi.entities.Matiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MatiereMapper {

    MatiereMapper INSTANCE = Mappers.getMapper(MatiereMapper.class);

    MatiereResponseDto fromEntityToResponse(Matiere matiere);
}

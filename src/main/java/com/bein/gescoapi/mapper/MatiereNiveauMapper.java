package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.MatiereNiveauResponseDto;
import com.bein.gescoapi.entities.MatiereNiveau;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MatiereNiveauMapper {

    MatiereNiveauMapper INSTANCE = Mappers.getMapper(MatiereNiveauMapper.class);

    MatiereNiveauResponseDto fromEntityToResponse(MatiereNiveau matiereNiveau);
}

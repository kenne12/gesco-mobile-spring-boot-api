package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.ClasseResponseDto;
import com.bein.gescoapi.entities.Classe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClasseMapper {

    ClasseMapper INSTANCE = Mappers.getMapper(ClasseMapper.class);

    ClasseResponseDto fromEntityToResponse(Classe classe);

}

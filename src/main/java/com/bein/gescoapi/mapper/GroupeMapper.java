package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.GroupeResponseDto;
import com.bein.gescoapi.entities.Groupe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GroupeMapper {

    GroupeMapper INSTANCE = Mappers.getMapper(GroupeMapper.class);

    GroupeResponseDto fromEntityToResponse(Groupe groupe);
}

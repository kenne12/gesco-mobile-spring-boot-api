package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.GroupeMatiereResponseDto;
import com.bein.gescoapi.entities.Groupematiere;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GroupeMatiereMapper {

    GroupeMatiereMapper INSTANCE = Mappers.getMapper(GroupeMatiereMapper.class);

    GroupeMatiereResponseDto fromEntityToResponse(Groupematiere groupematiere);
}

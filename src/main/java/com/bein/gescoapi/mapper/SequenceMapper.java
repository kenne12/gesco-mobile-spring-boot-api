package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.SequenceResponseDto;
import com.bein.gescoapi.entities.Sequence;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SequenceMapper {
    SequenceMapper INSTANCE = Mappers.getMapper(SequenceMapper.class);

    SequenceResponseDto fromEntityToResponse(Sequence sequence);
}

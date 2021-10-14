package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.NoteRequestPayload;
import com.bein.gescoapi.dto.NoteResponseDto;
import com.bein.gescoapi.entities.Note;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);

    NoteResponseDto fromEntityToResponse(Note note);

    Note fromRequestPayloadToEntity(NoteRequestPayload noteRequestPayload);
}

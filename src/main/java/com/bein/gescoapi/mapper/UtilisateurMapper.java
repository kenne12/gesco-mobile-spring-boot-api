package com.bein.gescoapi.mapper;

import com.bein.gescoapi.dto.UtilisateurRequestDto;
import com.bein.gescoapi.dto.UtilisateurResponseDto;
import com.bein.gescoapi.entities.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    public UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

    Utilisateur fromRequestToEntity(UtilisateurRequestDto utilisateurRequestDto);

    UtilisateurResponseDto fromEntityToResponse(Utilisateur utilisateur);
}

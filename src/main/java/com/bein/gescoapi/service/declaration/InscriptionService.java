package com.bein.gescoapi.service.declaration;

import com.bein.gescoapi.dto.InscriptionResponseDto;

import java.util.List;

public interface InscriptionService {

    List<InscriptionResponseDto> getAllActiveInscriptionByClasse(int idannee, int idclasse, int idinstitution);

    List<InscriptionResponseDto> getAllInscriptionByClasse(int idAnnee, int idClasse, int idInstitution);
}

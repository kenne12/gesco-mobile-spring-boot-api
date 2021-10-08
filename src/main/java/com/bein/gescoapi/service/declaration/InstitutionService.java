package com.bein.gescoapi.service.declaration;

import com.bein.gescoapi.dto.ClasseResponseDto;
import com.bein.gescoapi.entities.Classe;

import java.util.List;

public interface InstitutionService {

    List<ClasseResponseDto> findAllClasse();
}

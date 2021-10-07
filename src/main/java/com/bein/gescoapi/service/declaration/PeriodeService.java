package com.bein.gescoapi.service.declaration;

import com.bein.gescoapi.dto.AnneeResponseDto;
import com.bein.gescoapi.dto.PeriodeResponseDto;
import com.bein.gescoapi.entities.Anneescolaire;

import java.util.List;

public interface PeriodeService {

    List<AnneeResponseDto> findAllAnneeScolaire();

    List<PeriodeResponseDto> findAllTrimestreByIdanne(Integer idAnnee);

    List<PeriodeResponseDto> findAllSequenceByIdanne(Integer idAnnee);
}

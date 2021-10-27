package com.bein.gescoapi.service.declaration;

import com.bein.gescoapi.dto.EvaluationResponseDto;
import com.bein.gescoapi.dto.NoteRequestPayload;
import com.bein.gescoapi.dto.NoteResponseDto;

import java.util.List;

public interface NotationService {

    List<EvaluationResponseDto> findEvaluationByIdClasseAndIdperiode(int idClasse, int idPeriode);

    List<NoteResponseDto> getMasqueSaisi(long idEvaluation, int idClasse);

    void editNote(int idClasse, long idEvaluation, List<NoteRequestPayload> noteRequestPayloads);


    List<NoteResponseDto> getMarksByIdclasseAndIdevaluation(int idClasse, long idEvaluation);

    List<NoteResponseDto> getStudentMarksBySequence(int idInscription, int idPeriode);
}

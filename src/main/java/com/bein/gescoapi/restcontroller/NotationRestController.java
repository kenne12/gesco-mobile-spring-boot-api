package com.bein.gescoapi.restcontroller;


import com.bein.gescoapi.dto.EvaluationResponseDto;
import com.bein.gescoapi.dto.NoteRequestPayload;
import com.bein.gescoapi.dto.NoteResponseDto;
import com.bein.gescoapi.service.declaration.NotationService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notation")
public class NotationRestController {

    private final NotationService notationService;

    public NotationRestController(NotationService notationService) {
        this.notationService = notationService;
    }

    @GetMapping("/get-list-evaluations")
    public List<EvaluationResponseDto> findEvaluationByIdcalasseAndIperiode(@PathParam(value = "idclasse") int idClasse, @PathParam("idperiode") int idPeriode) {
        return notationService.findEvaluationByIdClasseAndIdperiode(idClasse, idPeriode);
    }

    @GetMapping("/get-masque-saisi")
    public List<NoteResponseDto> getMasqueSaisie(@PathParam("idEvaluation") long idEvaluation, int idClasse) {
        return notationService.getMasqueSaisi(idEvaluation, idClasse);
    }

    @PostMapping(path = "/edit-note-by-classe")
    public void editNoteByClasse(@PathParam( "idclasse") Integer idclasse, @PathParam("idevaluation") long idevaluation, @RequestBody List<NoteRequestPayload> noteRequestPayloads) {

            notationService.editNote(idclasse , idevaluation , noteRequestPayloads);
    }

}

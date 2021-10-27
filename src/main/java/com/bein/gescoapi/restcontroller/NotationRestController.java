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
    public List<EvaluationResponseDto> findEvaluationByIdcalasseAndIperiode(@PathParam("idclasse") int idclasse, @PathParam("idperiode") int idperiode) {
        return notationService.findEvaluationByIdClasseAndIdperiode(idclasse, idperiode);
    }

    @GetMapping("/get-masque-saisi")
    public List<NoteResponseDto> getMasqueSaisie(@PathParam("idevaluation") long idevaluation, @PathParam("idclasse") int idclasse) {
        return notationService.getMasqueSaisi(idevaluation, idclasse);
    }

    @PostMapping(path = "/edit-note-by-classe")
    public void editNoteByClasse(@PathParam("idclasse") Integer idclasse,
                                 @PathParam("idevaluation") long idevaluation, @RequestBody List<NoteRequestPayload> noteRequestPayloads) {
        notationService.editNote(idclasse, idevaluation, noteRequestPayloads);
    }

    @GetMapping("/get-class-mark-by-evaluation")
    public List<NoteResponseDto> getClassMarksBySequence(@PathParam("idclasse") Integer idclasse, @PathParam("idevaluation") Long idevaluation) {
        return notationService.getMarksByIdclasseAndIdevaluation(idclasse, idevaluation);
    }

    @GetMapping("/get-student-mark-by-sequence")
    public List<NoteResponseDto> getStudentMarksBySequence(@PathParam("idinscription") Integer idinscription, @PathParam("idperiode") Integer idperiode) {
        return notationService.getStudentMarksBySequence(idinscription, idperiode);
    }

}

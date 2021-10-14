package com.bein.gescoapi.restcontroller;

import com.bein.gescoapi.dto.InscriptionResponseDto;
import com.bein.gescoapi.service.declaration.InscriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/v1/eleve")
public class EleveController {
    private final InscriptionService inscriptionService;

    public EleveController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @GetMapping("/get-all-active-studend-by-class")
    public List<InscriptionResponseDto> getAllActiveStudentByClasse(@PathParam("idannee") Integer idannee, @PathParam("idclasse") Integer idclasse, @PathParam("idinstitution") Integer idinstitution) {
        return inscriptionService.getAllActiveInscriptionByClasse(idannee, idclasse, idinstitution);
    }

    @GetMapping("/get-all-studend-by-class")
    public List<InscriptionResponseDto> getAllActiveByClasse(@PathParam("idannee") int idAnnee, @PathParam("idclasse") int idClasse, @PathParam("idinstitution") int idInstitution) {
        return inscriptionService.getAllInscriptionByClasse(idAnnee, idClasse, idInstitution);
    }
}

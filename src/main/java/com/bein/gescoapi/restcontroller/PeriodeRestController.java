package com.bein.gescoapi.restcontroller;

import com.bein.gescoapi.dto.AnneeResponseDto;
import com.bein.gescoapi.dto.PeriodeResponseDto;
import com.bein.gescoapi.service.declaration.PeriodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/periode")
public class PeriodeRestController {

    private final PeriodeService periodeService;

    public PeriodeRestController(PeriodeService periodeService) {
        this.periodeService = periodeService;
    }

    @GetMapping(path = "/annee/all")
    public List<AnneeResponseDto> getAllAnneeScolaire() {
        return this.periodeService.findAllAnneeScolaire();
    }

    @GetMapping(path = "/annee/{id}/trimestre")
    public List<PeriodeResponseDto> getAllTrimestreByIdannee(@PathVariable(name = "id") Integer idAnnee) {
        return this.periodeService.findAllTrimestreByIdanne(idAnnee);
    }

    @GetMapping(path = "/annee/{id}/sequence")
    public List<PeriodeResponseDto> getAllSequenceByIdannee(@PathVariable(name = "id") Integer idAnnee) {
        return this.periodeService.findAllSequenceByIdanne(idAnnee);
    }

}

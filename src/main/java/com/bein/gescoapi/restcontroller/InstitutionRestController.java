package com.bein.gescoapi.restcontroller;

import com.bein.gescoapi.dto.ClasseResponseDto;
import com.bein.gescoapi.service.declaration.InstitutionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/institution")
public class InstitutionRestController {

    private final InstitutionService institutionService;

    public InstitutionRestController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping(path = "/classe/all")
    public List<ClasseResponseDto> findAllClasse() {
        return this.institutionService.findAllClasse();
    }

}

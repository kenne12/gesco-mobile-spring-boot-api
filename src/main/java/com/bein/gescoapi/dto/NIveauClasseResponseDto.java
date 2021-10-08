package com.bein.gescoapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NIveauClasseResponseDto {

    private Integer idniveauclasse;
    private String nom;
    private Integer numero;
}

package com.bein.gescoapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClasseResponseDto {
    private Integer idclasse;
    private String code;
    private String nom;
    private GroupeResponseDto groupe;
    private NiveauClasseResponseDto niveauclasse;
}

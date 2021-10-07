package com.bein.gescoapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AnneeResponseDto {
    private Integer idanneescolaire;
    private String code;
    private String nom;
    private Boolean actif;
}

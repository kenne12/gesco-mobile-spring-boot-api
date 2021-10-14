package com.bein.gescoapi.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Builder
@Data
public class SanteResponseDto {
    private Integer idsante;
    private String code;
    private String nom;
}

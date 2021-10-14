package com.bein.gescoapi.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Builder
@Data
public class StatutResponseDto {

    private Integer idstatut;
    private String code;
    private String nom;
}

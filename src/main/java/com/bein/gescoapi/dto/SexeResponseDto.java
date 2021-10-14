package com.bein.gescoapi.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Builder
@Data
public class SexeResponseDto {

    private Integer idsexe;
    private String code;
    private String nom;
}

package com.bein.gescoapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SequenceResponseDto {

    private Integer idsequence;
    private String nom;
    private Integer numero;
}

package com.bein.gescoapi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class TrimestreResponseDto {
    private Integer idTrimestre;
    private String nom;
    private Integer numero;
    private Date datedebut;
    private Date datefin;
    private String nomcolumn1;
    private String codecolumn1;
    private String nomcolumn2;
    private String codecolumn2;
}

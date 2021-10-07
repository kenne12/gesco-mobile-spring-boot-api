package com.bein.gescoapi.dto;

import com.bein.gescoapi.entities.Anneescolaire;
import com.bein.gescoapi.entities.Sequence;
import com.bein.gescoapi.entities.Trimestre;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class PeriodeResponseDto {
    private Integer idPeriode;
    private Date dateDebut;
    private Date dateFin;
    private String denomination;
    private Integer poids;
    private String codeperiode;
    private Boolean estdevoir;
    private Boolean estcompos;
    private Anneescolaire idanneescolaire;
    private Sequence idsequence;
    private Trimestre idTrimestre;
}

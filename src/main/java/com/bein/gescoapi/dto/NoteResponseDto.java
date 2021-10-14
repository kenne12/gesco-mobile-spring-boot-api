package com.bein.gescoapi.dto;

import com.bein.gescoapi.entities.Evaluation;
import com.bein.gescoapi.entities.Inscription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoteResponseDto {

    private Long idnote;
    private Double valeur;
    private String appreciation;
    private Boolean notifie;
    private Boolean markNotification;
    private Integer rang;
    private Double min;
    private Double max;
    private Double moy;
    private EvaluationResponseDto evaluation;
    private InscriptionResponseDto inscription;
}

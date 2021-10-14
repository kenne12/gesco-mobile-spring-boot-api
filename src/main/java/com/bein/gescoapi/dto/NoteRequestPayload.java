package com.bein.gescoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoteRequestPayload {

    private Long idnote;
    private Double valeur;
    private String appreciation;
    private Boolean notifie;
    private Boolean markNotification;
    private Integer rang;
    private Double min;
    private Double max;
    private Double moy;
    private Long evaluation;
    private Integer inscription;
}

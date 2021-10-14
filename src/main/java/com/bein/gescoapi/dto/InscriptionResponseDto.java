package com.bein.gescoapi.dto;

import com.bein.gescoapi.entities.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@Data
public class InscriptionResponseDto {

    private Integer idinscription;
    private Double montantinscription;
    private Double montanttd;
    private Date dateinscription;
    private Boolean etat;
    private Boolean nouveau;
    private String code;
    private Double avancepension;
    private Boolean redoublant;

    private AnneeResponseDto anneescolaire;
    private ClasseResponseDto classe;
    private EleveResponseDto eleve;
    private InstitutionResponseDto institution;
    private SanteResponseDto sante;
    private StatutResponseDto statut;
}

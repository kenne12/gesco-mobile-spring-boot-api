package com.bein.gescoapi.dto;

import com.bein.gescoapi.entities.Adresse;
import com.bein.gescoapi.entities.Institution;
import com.bein.gescoapi.entities.Sexe;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Builder
@Data
public class EleveResponseDto {

    private Integer ideleve;
    private String matricule;
    private String nom;
    private String prenom;
    private Date datenais;
    private String lieunais;
    private Boolean dosmedical;
    private Boolean etat;
    private Boolean terminal;
    private Boolean exclu;
    private String nomparent;
    private String prenomparent;
    private String nommere;
    private String prenommere;
    private Integer cumulsms;
    private AdresseResponseDto adresse;
    private InstitutionResponseDto institution;
    private SexeResponseDto sexe;
}

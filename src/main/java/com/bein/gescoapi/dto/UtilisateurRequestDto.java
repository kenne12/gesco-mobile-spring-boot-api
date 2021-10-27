package com.bein.gescoapi.dto;

import com.bein.gescoapi.entities.Institution;
import com.bein.gescoapi.entities.Privilege;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UtilisateurRequestDto {
    private Long idutilisateur;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private String repeatPassword;
    private Boolean etat;
    private Integer institution;
}

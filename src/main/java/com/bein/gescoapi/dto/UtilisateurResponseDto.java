package com.bein.gescoapi.dto;

import com.bein.gescoapi.entities.Institution;
import com.bein.gescoapi.entities.Privilege;
import lombok.Builder;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Builder
@Data
public class UtilisateurResponseDto {
    private Long idutilisateur;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private Date datecreation;
    private Boolean etat;
    private String photo;
    private Boolean principal;
    private List<Privilege> privilegeList;
    private Institution idinstitution;
}

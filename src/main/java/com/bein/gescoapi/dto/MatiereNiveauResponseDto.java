package com.bein.gescoapi.dto;

import com.bein.gescoapi.entities.Groupematiere;
import com.bein.gescoapi.entities.Matiere;
import com.bein.gescoapi.entities.Niveauclasse;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MatiereNiveauResponseDto {

    private Integer idmatiereNiveau;
    private Integer coefficient;
    private boolean notification;
    private GroupeMatiereResponseDto groupematiere;
    private MatiereResponseDto matiere;
    private NiveauClasseResponseDto niveauclasse;
}

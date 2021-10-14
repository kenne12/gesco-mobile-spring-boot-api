package com.bein.gescoapi.dto;

import com.bein.gescoapi.entities.Matiere;
import com.bein.gescoapi.entities.MatiereNiveau;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
public class GroupeMatiereResponseDto {
    private Integer idgroupematiere;
    private String code;
    private String nom;
}

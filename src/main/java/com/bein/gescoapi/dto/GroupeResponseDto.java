package com.bein.gescoapi.dto;

import com.bein.gescoapi.entities.Classe;
import com.bein.gescoapi.entities.Fraisscolarite;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
public class GroupeResponseDto {
    private Integer idgroupe;
    private String code;
    private String nom;
}

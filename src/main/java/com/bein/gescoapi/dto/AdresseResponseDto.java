package com.bein.gescoapi.dto;

import com.bein.gescoapi.entities.Eleve;
import com.bein.gescoapi.entities.Enseignant;
import com.bein.gescoapi.entities.Institution;
import com.bein.gescoapi.entities.Quartier;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
public class AdresseResponseDto {

    private Integer idadresse;
    private Integer idville;
    private String telephone;
    private String bp;
    private String email;
    private String siteweb;
    private String code;
    private String fax;
}

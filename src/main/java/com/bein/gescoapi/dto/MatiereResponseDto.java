package com.bein.gescoapi.dto;

import com.bein.gescoapi.entities.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
public class MatiereResponseDto {

    private Integer idmatiere;
    private String code;
    private String nom;
    private String nomAnglais;
}

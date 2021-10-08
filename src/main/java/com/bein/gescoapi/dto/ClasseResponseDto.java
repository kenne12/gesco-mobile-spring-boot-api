package com.bein.gescoapi.dto;

import com.bein.gescoapi.entities.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
public class ClasseResponseDto {
    private Integer idclasse;
    private String code;
    private String nom;
    private GroupeResponseDto groupe;
    private NIveauClasseResponseDto niveauclasse;
}

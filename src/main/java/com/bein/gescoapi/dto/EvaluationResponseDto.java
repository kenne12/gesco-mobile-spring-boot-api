package com.bein.gescoapi.dto;

import com.bein.gescoapi.entities.Institution;
import com.bein.gescoapi.entities.MatiereNiveau;
import com.bein.gescoapi.entities.Note;
import com.bein.gescoapi.entities.Periode;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@Data
public class EvaluationResponseDto {
    private Long idevaluation;
    private Date dateevaluation;
    private Date heureDebut;
    private Date heureFin;
    private Integer coefficient;
    private InstitutionResponseDto institution;
    private MatiereNiveauResponseDto matiereNiveau;
    private PeriodeResponseDto periode;
}

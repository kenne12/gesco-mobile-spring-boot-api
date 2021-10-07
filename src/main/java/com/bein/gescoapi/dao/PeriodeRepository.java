package com.bein.gescoapi.dao;

import com.bein.gescoapi.entities.Periode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeriodeRepository extends JpaRepository<Periode, Integer> {

    @Query("select p from Periode p where p.idanneescolaire.idanneescolaire=:idAnnee and p.idsequence is null and p.idTrimestre is not null  order by p.idTrimestre.numero")
    List<Periode> findAllTrimestreByIdannee(@Param(value = "idAnnee") Integer idAnnee);

    @Query("select p from Periode p where p.idanneescolaire.idanneescolaire=:idAnnee and p.idsequence is not null and p.idTrimestre is not null order by p.idsequence.numero")
    List<Periode> findAllSequenceByIdannee(@Param(value = "idAnnee") Integer idAnnee);
}

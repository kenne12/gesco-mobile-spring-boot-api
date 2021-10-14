package com.bein.gescoapi.dao;

import com.bein.gescoapi.entities.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

    @Query("select e from Evaluation e where e.idmatiereNiveau.idniveauclasse.idniveauclasse=:idNiveau AND e.idPeriode.idPeriode=:idPeriode order by e.idmatiereNiveau.idmatiere.nom")
    List<Evaluation> findByIdniveauAndIdperiode(@Param("idNiveau") int idNiveau, @Param("idPeriode") int idPeriode);
}

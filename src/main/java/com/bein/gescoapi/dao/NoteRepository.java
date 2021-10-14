package com.bein.gescoapi.dao;

import com.bein.gescoapi.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("select max(n.idnote) from Note n")
    Long nextIdNote();

    @Query("select n from Note n where n.idevaluation.idevaluation=:idEvaluation and n.idinscription.idclasse.idclasse=:idClasse order by  n.idinscription.ideleve.nom")
    List<Note> findAllByIdEvaluationAndIdClasse(@Param(value = "idEvaluation") long idEvaluation, @Param("idClasse") int idClasse);

    @Query("select max(n.valeur) from Note n where n.idinscription.idclasse.idclasse=:idclasse and n.idevaluation.idevaluation=:idevaluation")
    Double findMax(@Param("idclasse") Integer idclasse, @Param("idevaluation") Long idevaluation);

    @Query("select min(n.valeur) from Note n where n.idinscription.idclasse.idclasse=:idclasse and n.idevaluation.idevaluation=:idevaluation")
    Double findMin(@Param("idclasse") Integer idclasse, @Param("idevaluation") Long idevaluation);

    @Query("select avg (n.valeur) from Note n where n.idinscription.idclasse.idclasse=:idclasse and n.idevaluation.idevaluation=:idevaluation")
    Double findAverage(@Param("idclasse") Integer idclasse, @Param("idevaluation") Long idevaluation);
}

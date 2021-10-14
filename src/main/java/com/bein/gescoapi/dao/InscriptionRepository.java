package com.bein.gescoapi.dao;

import com.bein.gescoapi.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {

    @Query("select i from Inscription i where i.idanneescolaire.idanneescolaire=:idAnnee and i.idclasse.idclasse=:idClasse and i.idinstitution.idinstitution=:idInstitution and i.etat=:etat  order by i.ideleve.nom")
    List<Inscription> findInscriptionByIdanneescolaireAndIdclasseEleveActif(@Param("idAnnee") Integer idAnnee, @Param("idClasse") Integer idClasse, @Param("idInstitution") Integer idInstitution , @Param("etat") boolean etat);

    @Query("select i from Inscription i where i.idanneescolaire.idanneescolaire=:idAnnee and i.idclasse.idclasse=:idClasse and i.idinstitution.idinstitution=:idInstitution order by i.ideleve.nom")
    List<Inscription> findInscriptionByIdanneescolaireAndIdclasseEleve(@Param("idAnnee") int idAnnee, @Param("idClasse") int idClasse, @Param("idInstitution") int idInstitution);
}

package com.bein.gescoapi.dao;

import com.bein.gescoapi.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe, Integer> {

    @Query("select c from Classe c order by c.idniveauclasse.numero , c.nom")
    List<Classe> findAllClasse();
}

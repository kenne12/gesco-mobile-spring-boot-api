package com.bein.gescoapi.dao;

import com.bein.gescoapi.entities.Anneescolaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnneeScolaireRepository extends JpaRepository<Anneescolaire, Integer> {

    @Query("select a from Anneescolaire a order by a.code")
    public List<Anneescolaire> getAllAnnee();
}

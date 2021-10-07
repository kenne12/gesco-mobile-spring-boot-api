package com.bein.gescoapi.dao;

import com.bein.gescoapi.entities.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EleveRepository extends JpaRepository<Eleve, Integer> {
}

package com.bein.gescoapi.dao;

import com.bein.gescoapi.entities.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution, Integer> {
}

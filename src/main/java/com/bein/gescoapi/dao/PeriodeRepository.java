package com.bein.gescoapi.dao;

import com.bein.gescoapi.entities.Periode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodeRepository extends JpaRepository<Periode, Integer> {
}

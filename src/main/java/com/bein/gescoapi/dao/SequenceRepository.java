package com.bein.gescoapi.dao;

import com.bein.gescoapi.entities.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SequenceRepository extends JpaRepository<Sequence, Integer> {
}

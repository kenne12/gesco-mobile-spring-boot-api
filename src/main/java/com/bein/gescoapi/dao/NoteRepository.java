package com.bein.gescoapi.dao;

import com.bein.gescoapi.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}

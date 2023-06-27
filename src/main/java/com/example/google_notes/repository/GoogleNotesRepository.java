package com.example.google_notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.google_notes.model.GoogleNotes;

@Repository
public interface GoogleNotesRepository  extends JpaRepository<GoogleNotes, Long>{

}

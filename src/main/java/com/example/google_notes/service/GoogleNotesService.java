package com.example.google_notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.google_notes.exception.ResourceNotFoundException;
import com.example.google_notes.model.GoogleNotes;
import com.example.google_notes.repository.GoogleNotesRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

@Service
public class GoogleNotesService {

    private GoogleNotesRepository googleNotesRepository;

    @Autowired
    public GoogleNotesService(GoogleNotesRepository googleNotesRepository) {
        this.googleNotesRepository = googleNotesRepository;
    }

    public List<GoogleNotes> getAllGoogleNotes() {
        Sort sortByLastModifiedDesc = Sort.by(Direction.DESC, "lastModified");
        return googleNotesRepository.findAll(sortByLastModifiedDesc);
    }

    public GoogleNotes createGoogleNote(GoogleNotes googleNotes) {
        googleNotes.setColor("#97BDDE");
        googleNotes.setPinned(false);
        return googleNotesRepository.save(googleNotes);
    }

    public GoogleNotes getGoogleNoteById(Long id) {
        return googleNotesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Google Note does not exist with id: " + id));
    }

    public GoogleNotes updateGoogleNote(Long id, GoogleNotes googleNotesDetails) {
        GoogleNotes googleNotes = googleNotesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Google Note does not exist with id: " + id));

        googleNotes.setTitleName(googleNotesDetails.getTitleName() == null ? googleNotes.getTitleName() : googleNotesDetails.getTitleName());
        googleNotes.setNotecontent(googleNotesDetails.getNotecontent() == null ? googleNotes.getNotecontent() : googleNotesDetails.getNotecontent());
        googleNotes.setColor(googleNotesDetails.getColor() == null ? googleNotes.getColor() : googleNotesDetails.getColor());
        googleNotes.setPinned(googleNotesDetails.getPinned() == null ? googleNotes.getPinned() : googleNotesDetails.getPinned());

        return googleNotesRepository.save(googleNotes);
    }


    public GoogleNotes updateGoogleNoteLabels(Long id, GoogleNotes googleNotesDetails) {
        GoogleNotes googleNotes = googleNotesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Google Note does not exist with id: " + id));
    
        googleNotes.setLabels(googleNotesDetails.getLabels());

        return googleNotesRepository.save(googleNotes);
    }
    public void deleteGoogleNoteById(Long id) {
        GoogleNotes googleNotes = googleNotesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Google Note does not exist with id: " + id));

        googleNotesRepository.delete(googleNotes);
    }
}

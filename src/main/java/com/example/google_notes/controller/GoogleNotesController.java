package com.example.google_notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.google_notes.model.GoogleNotes;
import com.example.google_notes.service.GoogleNotesService;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1/")
public class GoogleNotesController {

    @Autowired
    private GoogleNotesService googleNotesService;

    // get all google notes
    @GetMapping("/googleNotes")
    public List<GoogleNotes> getAllGoogleNotes() {
        return googleNotesService.getAllGoogleNotes();
    }

    // create google notes rest api
    @PostMapping("/googleNotes")
    public GoogleNotes createGoogleNote(@RequestBody GoogleNotes googleNotes) {
        return googleNotesService.createGoogleNote(googleNotes);
    }

    // get googleNotes by id rest api
    @GetMapping("/googleNotes/{id}")
    public ResponseEntity<GoogleNotes> getGoogleNoteById(@PathVariable Long id) {
        GoogleNotes googleNotes = googleNotesService.getGoogleNoteById(id);
        return ResponseEntity.ok(googleNotes);
    }

    // update googleNotes rest api
    @PutMapping("/googleNotes/{id}")
    public ResponseEntity<GoogleNotes> updateGoogleNote(
            @PathVariable Long id, @RequestBody GoogleNotes googleNotesDetails) {
        GoogleNotes updatedGoogleNotes = googleNotesService.updateGoogleNote(id, googleNotesDetails);
        return ResponseEntity.ok(updatedGoogleNotes);
    }

    // delete google notes rest api
    @DeleteMapping("/googleNotes/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteGoogleNote(@PathVariable Long id) {
        googleNotesService.deleteGoogleNoteById(id);
        Map<String, Boolean> response = new HashMap<>();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}

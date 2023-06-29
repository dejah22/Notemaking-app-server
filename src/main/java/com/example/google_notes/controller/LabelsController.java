package com.example.google_notes.controller;

import com.example.google_notes.dto.GoogleNotesDTO;
import com.example.google_notes.dto.LabelsDTO;
import com.example.google_notes.model.GoogleNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.example.google_notes.model.Labels;
import com.example.google_notes.service.LabelsService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class LabelsController {
    @Autowired
    private LabelsService LabelsService;

    // get all google notes
    @GetMapping("/labels")
    public List<LabelsDTO> getAllLabels() {
        List<Labels> labels = LabelsService.getAllLabels();
        List<LabelsDTO> labelDTOs = new ArrayList<LabelsDTO>();

        for (Labels label : labels) {
            LabelsDTO labelDTO = new LabelsDTO(label);
            labelDTOs.add(labelDTO);
        }

        return labelDTOs;
    }

    // create google notes rest api
    @PostMapping("/labels")
    public LabelsDTO createLabel(@RequestBody Labels Labels) {
        return new LabelsDTO(LabelsService.createlabel(Labels));
    }

    // get Labels by id rest api
    @GetMapping("/labels/{id}")
    public ResponseEntity<LabelsDTO> getLabelById(@PathVariable Long id) {
        Labels label = LabelsService.getlabelById(id);
        LabelsDTO labelDTO = new LabelsDTO(label);
        return ResponseEntity.ok(labelDTO);
    }

    // get google-notes that have a particular label
    @GetMapping("/labels/google-notes/{id}")
    public List<GoogleNotesDTO> getGoogleNotesByLabelId(@PathVariable Long id) {
        Labels requestlabel = LabelsService.getlabelById(id);
        List<GoogleNotesDTO> googleNotesDTOs = new ArrayList<>();
        for (GoogleNotes googleNotes : requestlabel.getGoogleNotes()) {
            GoogleNotesDTO googleNotesDTO = new GoogleNotesDTO(googleNotes);
            googleNotesDTOs.add(googleNotesDTO);
        }
        return googleNotesDTOs;
    }

    // update Labels rest api
    @PutMapping("/labels/{id}")
    public ResponseEntity<LabelsDTO> updateLabel(
            @PathVariable Long id, @RequestBody Labels LabelsDetails) {
        Labels updatedLabels = LabelsService.updatelabel(id, LabelsDetails);
        LabelsDTO updatedLabelDTO = new LabelsDTO(updatedLabels);
        return ResponseEntity.ok(updatedLabelDTO);
    }

    // delete google notes rest api
    @DeleteMapping("/labels/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteLabel(@PathVariable Long id) {
        LabelsService.deletelabelById(id);
        Map<String, Boolean> response = new HashMap<>();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}

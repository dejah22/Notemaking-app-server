package com.example.google_notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.google_notes.model.Labels;
import com.example.google_notes.service.LabelsService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class LabelsController {
    @Autowired
    private LabelsService LabelsService;

    // get all google notes
    @GetMapping("/Labels")
    public List<Labels> getAllLabels() {
        return LabelsService.getAllLabels();
    }

    // create google notes rest api
    @PostMapping("/Labels")
    public Labels createLabel(@RequestBody Labels Labels) {
        return LabelsService.createlabel(Labels);
    }

    // get Labels by id rest api
    @GetMapping("/Labels/{id}")
    public ResponseEntity<Labels> getLabelById(@PathVariable Long id) {
        Labels Labels = LabelsService.getlabelById(id);
        return ResponseEntity.ok(Labels);
    }

    // update Labels rest api
    @PutMapping("/Labels/{id}")
    public ResponseEntity<Labels> updateLabel(
            @PathVariable Long id, @RequestBody Labels LabelsDetails) {
        Labels updatedLabels = LabelsService.updatelabel(id, LabelsDetails);
        return ResponseEntity.ok(updatedLabels);
    }

    // delete google notes rest api
    @DeleteMapping("/Labels/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteLabel(@PathVariable Long id) {
        LabelsService.deletelabelById(id);
        Map<String, Boolean> response = new HashMap<>();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}

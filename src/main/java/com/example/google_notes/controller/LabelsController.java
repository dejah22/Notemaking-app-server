package com.example.google_notes.controller;

import com.example.google_notes.dto.LabelsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<LabelsDTO> getAllLabels() {
        List<Labels> labels = LabelsService.getAllLabels();
        List<LabelsDTO> labelDTOs = new ArrayList<LabelsDTO>();

        for (Labels label : labels) {
            LabelsDTO labelDTO = new LabelsDTO();
            labelDTO.setId(label.getId());
            labelDTO.setTimeCreated(label.getTimeCreated());
            labelDTO.setName(label.getName());

            labelDTOs.add(labelDTO);
        }

        return labelDTOs;
    }

    // create google notes rest api
    @PostMapping("/Labels")
    public Labels createLabel(@RequestBody Labels Labels) {
        return LabelsService.createlabel(Labels);
    }

    // get Labels by id rest api
    @GetMapping("/Labels/{id}")
    public ResponseEntity<LabelsDTO> getLabelById(@PathVariable Long id) {
        Labels label = LabelsService.getlabelById(id);
        LabelsDTO labelDTO = new LabelsDTO();
        labelDTO.setId(label.getId());
        labelDTO.setTimeCreated(label.getTimeCreated());
        labelDTO.setName(label.getName());
        return ResponseEntity.ok(labelDTO);
    }

    // update Labels rest api
    @PutMapping("/Labels/{id}")
    public ResponseEntity<LabelsDTO> updateLabel(
            @PathVariable Long id, @RequestBody Labels LabelsDetails) {
        Labels updatedLabels = LabelsService.updatelabel(id, LabelsDetails);
        LabelsDTO updatedLabelDTO = new LabelsDTO();
        updatedLabelDTO.setId(updatedLabels.getId());
        updatedLabelDTO.setTimeCreated(updatedLabels.getTimeCreated());
        updatedLabelDTO.setName(updatedLabels.getName());
        return ResponseEntity.ok(updatedLabelDTO);
    }

    // delete google notes rest api
    @DeleteMapping("/Labels/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteLabel(@PathVariable Long id) {
        LabelsService.deletelabelById(id);
        Map<String, Boolean> response = new HashMap<>();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}

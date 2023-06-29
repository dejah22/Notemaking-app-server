package com.example.google_notes.service;

import com.example.google_notes.model.GoogleNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.google_notes.exception.ResourceNotFoundException;
import com.example.google_notes.model.Labels;
import com.example.google_notes.repository.LabelsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Service
public class LabelsService {

    private LabelsRepository labelsRepository;

    @Autowired
    public LabelsService(LabelsRepository labelsRepository) {
        this.labelsRepository = labelsRepository;
    }

    public List<Labels> getAllLabels() {
        Sort sortByLastModifiedDesc = Sort.by(Direction.ASC, "timeCreated");
        return labelsRepository.findAll(sortByLastModifiedDesc);
    }

    public Labels createlabel(Labels labels) {
        return labelsRepository.save(labels);
    }

    public Labels getlabelById(Long id) {
        return labelsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Google Note does not exist with id: " + id));
    }
    public Labels updatelabel(Long id, Labels labelsDetails) {
        Labels labels = labelsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Google Note does not exist with id: " + id));

       labels.setName(labelsDetails.getName());
        return labelsRepository.save(labels);
    }

    public void deletelabelById(Long id) {
        Labels labels = labelsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Google Note does not exist with id: " + id));

        labelsRepository.delete(labels);
    }
}

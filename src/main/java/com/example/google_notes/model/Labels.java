

package com.example.google_notes.model;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "labels")
public class Labels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToMany(mappedBy = "labels")
    private Set<GoogleNotes> googleNotes = new HashSet<>();



    @CreationTimestamp
    @Column(name = "time_created")
    private LocalDateTime timeCreated;

    @Column(name = "name")
    private String name;

    public Labels(String name) {
        this.name = name;
    }

    public Labels() {

    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


package com.example.google_notes.model;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name = "googlenotes")
public class GoogleNotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(
            name = "googlenotes_labels",
            joinColumns = @JoinColumn(name = "googlenotes_id"),
            inverseJoinColumns = @JoinColumn(name = "labels_id")
    )
    private Set<Labels> labels = new HashSet<>();

    @Column(name = "titleName")
    private String titleName;

    @Column(name = "notecontent", length = 750)
    private String notecontent;

    @Column(name = "color")
    private String color;

    @Column(name = "isPinned")
    private Boolean isPinned;

    @CreationTimestamp
    @Column(name = "time_created")
    private LocalDateTime timeCreated;

    @UpdateTimestamp
    @Column(name = "last_modified")
    private LocalDateTime lastModified;


    public GoogleNotes() {
    }

    public GoogleNotes(String title, String content) {
        this.titleName = title;
        this.notecontent = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getNotecontent() {
        return notecontent;
    }

    public void setNotecontent(String notecontent) {
        this.notecontent = notecontent;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }
// added a commment
    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public Boolean getPinned() {
        return isPinned;
    }

    public void setPinned(Boolean pinned) {
        isPinned = pinned;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Labels> getLabels() {
        return labels;
    }

    public void setLabels(Set<Labels> labels) {
        this.labels = labels;
    }

    public void addLabel(Labels label) {
        this.labels.add(label);
        label.getGoogleNotes().add(this);
    }

    public void removeLabel(Labels label) {
        this.labels.remove(label);
        label.getGoogleNotes().remove(this);
    }
}

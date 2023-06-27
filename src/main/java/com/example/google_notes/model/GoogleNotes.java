package com.example.google_notes.model;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name = "googlenotes")
public class GoogleNotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titleName")
    private String titleName;

    @Column(name = "notecontent")
    private String notecontent;

    @Column(name = "color")
    private String color;

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

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

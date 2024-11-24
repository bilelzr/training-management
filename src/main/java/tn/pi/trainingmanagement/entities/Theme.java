package tn.pi.trainingmanagement.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table
@Entity(name = "theme")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "theme_seq")
    @SequenceGenerator(name = "theme_seq", sequenceName = "theme_sequence", allocationSize = 1)
    @Column(name = "theme_pk_id")
    private long themeId;
    @Column(name = "thene_name", unique = true)
    private String themeName;
    @Column(name = "theme_description")
    private String themeDescription;
    @Column(name = "created_at")
    private LocalDateTime createdAt;


    public Theme() {
    }

    public Theme(String themeName, String themeDescription, LocalDateTime createdAt) {
        this.themeName = themeName;
        this.themeDescription = themeDescription;
        this.createdAt = createdAt;
    }

    public Theme(long themeId, String themeName, String themeDescription, LocalDateTime createdAt) {
        this.themeId = themeId;
        this.themeName = themeName;
        this.themeDescription = themeDescription;
        this.createdAt = createdAt;
    }

    public long getThemeId() {
        return themeId;
    }

    public void setThemeId(long themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getThemeDescription() {
        return themeDescription;
    }

    public void setThemeDescription(String themeDescription) {
        this.themeDescription = themeDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

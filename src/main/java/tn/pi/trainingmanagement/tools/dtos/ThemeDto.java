package tn.pi.trainingmanagement.tools.dtos;


import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class ThemeDto {

    long themeId;
    private String themeName;
    private String themeDescription;
    private LocalDateTime createdAt;


    public ThemeDto(long themeId, String themeName, String themeDescription, LocalDateTime createdAt) {
        this.themeId = themeId;
        this.themeName = themeName;
        this.themeDescription = themeDescription;
        this.createdAt = createdAt;
    }

    public ThemeDto() {
    }

    public ThemeDto(String themeName, String themeDescription, LocalDateTime createdAt) {
        this.themeName = themeName;
        this.themeDescription = themeDescription;
        this.createdAt = createdAt;
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

    public long getThemeId() {
        return themeId;
    }

    public void setThemeId(long themeId) {
        this.themeId = themeId;
    }
}

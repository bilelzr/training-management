package tn.pi.trainingmanagement.tools.dtos;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Builder
public class TrainingProgramDto {

    private long trainingProgramId;


    private List<ThemeDto> themeList;

    private String programName;
    private String programDescription;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;


    public TrainingProgramDto() {
    }


    public TrainingProgramDto(long trainingProgramId, List<ThemeDto> themeList, String programName, String programDescription, LocalDate startDate, LocalDate endDate, LocalDateTime createdAt) {
        this.trainingProgramId = trainingProgramId;
        this.themeList = themeList;
        this.programName = programName;
        this.programDescription = programDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = createdAt;
    }

    public long getTrainingProgramId() {
        return trainingProgramId;
    }

    public void setTrainingProgramId(long trainingProgramId) {
        this.trainingProgramId = trainingProgramId;
    }

    public List<ThemeDto> getThemeList() {
        return themeList;
    }

    public void setThemeList(List<ThemeDto> themeList) {
        this.themeList = themeList;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
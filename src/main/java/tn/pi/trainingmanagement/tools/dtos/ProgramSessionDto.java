package tn.pi.trainingmanagement.tools.dtos;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
public class ProgramSessionDto {


    private long programSessionId;
    private TrainingProgramDto trainingProgram;
    private String sessionTitle;
    private LocalDate sessionDate;
    private LocalTime sessionStartTime;
    private LocalTime sessionEndTime;
    private long trainerFk;
    private LocalDateTime createdAt;


    public ProgramSessionDto() {
    }

    public ProgramSessionDto(TrainingProgramDto trainingProgram, String sessionTitle, LocalDate sessionDate, LocalTime sessionStartTime, LocalTime sessionEndTime, long trainerFk, LocalDateTime createdAt) {
        this.trainingProgram = trainingProgram;
        this.sessionTitle = sessionTitle;
        this.sessionDate = sessionDate;
        this.sessionStartTime = sessionStartTime;
        this.sessionEndTime = sessionEndTime;
        this.trainerFk = trainerFk;
        this.createdAt = createdAt;
    }

    public ProgramSessionDto(long programSessionId, TrainingProgramDto trainingProgram, String sessionTitle, LocalDate sessionDate, LocalTime sessionStartTime, LocalTime sessionEndTime, long trainerFk, LocalDateTime createdAt) {
        this.programSessionId = programSessionId;
        this.trainingProgram = trainingProgram;
        this.sessionTitle = sessionTitle;
        this.sessionDate = sessionDate;
        this.sessionStartTime = sessionStartTime;
        this.sessionEndTime = sessionEndTime;
        this.trainerFk = trainerFk;
        this.createdAt = createdAt;
    }

    public long getProgramSessionId() {
        return programSessionId;
    }

    public void setProgramSessionId(long programSessionId) {
        this.programSessionId = programSessionId;
    }

    public TrainingProgramDto getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(TrainingProgramDto trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public String getSessionTitle() {
        return sessionTitle;
    }

    public void setSessionTitle(String sessionTitle) {
        this.sessionTitle = sessionTitle;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public LocalTime getSessionStartTime() {
        return sessionStartTime;
    }

    public void setSessionStartTime(LocalTime sessionStartTime) {
        this.sessionStartTime = sessionStartTime;
    }

    public LocalTime getSessionEndTime() {
        return sessionEndTime;
    }

    public void setSessionEndTime(LocalTime sessionEndTime) {
        this.sessionEndTime = sessionEndTime;
    }

    public long getTrainerFk() {
        return trainerFk;
    }

    public void setTrainerFk(long trainerFk) {
        this.trainerFk = trainerFk;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

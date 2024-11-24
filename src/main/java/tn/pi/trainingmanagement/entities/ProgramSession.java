package tn.pi.trainingmanagement.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Table
@Entity(name = "program_sessions")
public class ProgramSession {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "session_seq")
    @SequenceGenerator(name = "session_seq", sequenceName = "session_sequence", allocationSize = 1)
    private long programSessionId;

    @ManyToOne
    @JoinColumn(name = "training_program_pk_id", nullable = false) // Foreign key column
    private TrainingProgram trainingProgram;
    private String sessionTitle;
    private LocalDate sessionDate;
    private LocalTime sessionStartTime;
    private LocalTime sessionEndTime;
    private long trainerFk;
    private LocalDateTime createdAt;

    public ProgramSession() {
    }

    public ProgramSession(long programSessionId, TrainingProgram trainingProgram, String sessionTitle, LocalDate sessionDate, LocalTime sessionStartTime, LocalTime sessionEndTime, long trainerFk, LocalDateTime createdAt) {
        this.programSessionId = programSessionId;
        this.trainingProgram = trainingProgram;
        this.sessionTitle = sessionTitle;
        this.sessionDate = sessionDate;
        this.sessionStartTime = sessionStartTime;
        this.sessionEndTime = sessionEndTime;
        this.trainerFk = trainerFk;
        this.createdAt = createdAt;
    }

    public TrainingProgram getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(TrainingProgram trainingProgram) {
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


    public long getProgramSessionId() {
        return programSessionId;
    }

    public void setProgramSessionId(long programSessionId) {
        this.programSessionId = programSessionId;
    }
}

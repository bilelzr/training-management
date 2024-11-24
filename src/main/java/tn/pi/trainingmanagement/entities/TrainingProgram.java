package tn.pi.trainingmanagement.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Table
@Entity(name = "training_program")
public class TrainingProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training_program_seq")
    @SequenceGenerator(name = "training_program_seq", sequenceName = "training_program_seq", allocationSize = 1)
    @Column(name = "training_program_pk_id")
    private long trainingProgramId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "theme_traingin_program",
            joinColumns = @JoinColumn(name = "training_program_pk_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_pk_id")
    )
    private List<Theme> themeList;
    private String programName;
    private String programDescription;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;



    @OneToMany(mappedBy = "trainingProgram", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgramSession> programSessions;

    public TrainingProgram() {
    }

    public TrainingProgram(long trainingProgramId, List<Theme> themeList, String programName, String programDescription, LocalDate startDate, LocalDate endDate, LocalDateTime createdAt, List<ProgramSession> programSessions) {
        this.trainingProgramId = trainingProgramId;
        this.themeList = themeList;
        this.programName = programName;
        this.programDescription = programDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = createdAt;
        this.programSessions = programSessions;
    }

    public long getTrainingProgramId() {
        return trainingProgramId;
    }

    public void setTrainingProgramId(long trainingProgramId) {
        this.trainingProgramId = trainingProgramId;
    }

    public List<Theme> getThemeList() {
        return themeList;
    }

    public void setThemeList(List<Theme> themeList) {
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

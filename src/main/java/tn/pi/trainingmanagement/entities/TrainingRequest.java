package tn.pi.trainingmanagement.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Table
@Entity(name = "training_request")
public class TrainingRequest {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training_request_seq")
    @SequenceGenerator(name = "training_request_seq", sequenceName = "training_request_sequence", allocationSize = 1)
    @Column(name = "training_request_pk_id")
    private long trainingRequestId;

    @Column(name = "candidate_fk_id")
    private long candidateId;

    @ManyToOne(fetch = FetchType.LAZY)
    private TrainingProgram trainingProgram;
    private Status status;
    private LocalDate requestDate;
    private LocalDate approvedDate;
    private LocalDate canceledDate;


    public TrainingRequest() {

    }


    public TrainingRequest(long trainingRequestId, long candidateId, TrainingProgram trainingProgram, Status status, LocalDate requestDate, LocalDate approvedDate, LocalDate canceledDate) {
        this.trainingRequestId = trainingRequestId;
        this.candidateId = candidateId;
        this.trainingProgram = trainingProgram;
        this.status = status;
        this.requestDate = requestDate;
        this.approvedDate = approvedDate;
        this.canceledDate = canceledDate;
    }

    public TrainingRequest(long candidateId, TrainingProgram trainingProgram, Status status, LocalDate requestDate, LocalDate approvedDate, LocalDate canceledDate) {
        this.candidateId = candidateId;
        this.trainingProgram = trainingProgram;
        this.status = status;
        this.requestDate = requestDate;
        this.approvedDate = approvedDate;
        this.canceledDate = canceledDate;
    }

    public LocalDate getCanceledDate() {
        return canceledDate;
    }

    public void setCanceledDate(LocalDate canceledDate) {
        this.canceledDate = canceledDate;
    }

    public LocalDate getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(LocalDate approvedDate) {
        this.approvedDate = approvedDate;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public TrainingProgram getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(long candidateId) {
        this.candidateId = candidateId;
    }

    public long getTrainingRequestId() {
        return trainingRequestId;
    }

    public void setTrainingRequestId(long trainingRequestId) {
        this.trainingRequestId = trainingRequestId;
    }
}

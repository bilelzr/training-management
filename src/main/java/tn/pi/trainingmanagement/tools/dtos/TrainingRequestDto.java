package tn.pi.trainingmanagement.tools.dtos;

import lombok.Builder;
import tn.pi.trainingmanagement.entities.Status;

import java.time.LocalDate;

@Builder
public class TrainingRequestDto {

    private long trainingRequestId;
    private long candidateId;
    private TrainingProgramDto trainingProgram;
    private Status status;
    private LocalDate requestDate;
    private LocalDate approvedDate;
    private LocalDate canceledDate;


    public TrainingRequestDto() {
    }


    public TrainingRequestDto(long trainingRequestId, long candidateId, TrainingProgramDto trainingProgram, Status status, LocalDate requestDate, LocalDate approvedDate, LocalDate canceledDate) {
        this.trainingRequestId = trainingRequestId;
        this.candidateId = candidateId;
        this.trainingProgram = trainingProgram;
        this.status = status;
        this.requestDate = requestDate;
        this.approvedDate = approvedDate;
        this.canceledDate = canceledDate;
    }

    public TrainingRequestDto(long candidateId, TrainingProgramDto trainingProgram, Status status, LocalDate requestDate, LocalDate approvedDate, LocalDate canceledDate) {
        this.candidateId = candidateId;
        this.trainingProgram = trainingProgram;
        this.status = status;
        this.requestDate = requestDate;
        this.approvedDate = approvedDate;
        this.canceledDate = canceledDate;
    }

    public long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(long candidateId) {
        this.candidateId = candidateId;
    }

    public TrainingProgramDto getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(TrainingProgramDto trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDate getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(LocalDate approvedDate) {
        this.approvedDate = approvedDate;
    }

    public LocalDate getCanceledDate() {
        return canceledDate;
    }

    public void setCanceledDate(LocalDate canceledDate) {
        this.canceledDate = canceledDate;
    }

    public long getTrainingRequestId() {
        return trainingRequestId;
    }

    public void setTrainingRequestId(long trainingRequestId) {
        this.trainingRequestId = trainingRequestId;
    }
}

package tn.pi.trainingmanagement.services.training_request;

import tn.pi.trainingmanagement.tools.dtos.TrainingRequestDto;

import java.time.LocalDate;
import java.util.List;

public interface ITraningRequestService {


    List<TrainingRequestDto> getAllTrainingRequests();

    List<TrainingRequestDto> getAllTrainingRequestByStatus(String status);

    List<TrainingRequestDto> getTrainingRequestByTrainingProgramId(long trainingProgramId);

    List<TrainingRequestDto> getTrainingRequestByCandidateId(long candidateId);

    TrainingRequestDto createTrainingRequest(TrainingRequestDto trainingRequestDto);

    TrainingRequestDto updateTrainingRequest(TrainingRequestDto trainingRequestDto);

    void deleteTrainingRequest(long trainingRequestId);

    List<TrainingRequestDto> getAllTrainingRequestsWhenDateBeetween(LocalDate startDate, LocalDate endDate);
}

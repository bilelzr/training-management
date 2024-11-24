package tn.pi.trainingmanagement.services.training_request;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.pi.trainingmanagement.entities.Status;
import tn.pi.trainingmanagement.entities.TrainingProgram;
import tn.pi.trainingmanagement.entities.TrainingRequest;
import tn.pi.trainingmanagement.repositories.TrainingRequestRepository;
import tn.pi.trainingmanagement.services.training_program.ITrainingProgramService;
import tn.pi.trainingmanagement.tools.Tools;
import tn.pi.trainingmanagement.tools.dtos.TrainingRequestDto;
import tn.pi.trainingmanagement.tools.dtos.externalDtos.CandidateDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingRequestServiceServiceImpl implements ITraningRequestService {

    @Value("${host.server.candidate}")
    private String hostServerCandidateManagement;

    private final TrainingRequestRepository trainingRequestRepository;
    private final RestTemplate restTemplate;
    private final ITrainingProgramService trainingProgramService;


    public TrainingRequestServiceServiceImpl(TrainingRequestRepository trainingRequestRepository, RestTemplate restTemplate, ITrainingProgramService trainingProgramService) {
        this.trainingRequestRepository = trainingRequestRepository;
        this.restTemplate = restTemplate;
        this.trainingProgramService = trainingProgramService;
    }


    @Override
    public List<TrainingRequestDto> getAllTrainingRequests() {
        List<TrainingRequest> trainingRequests = trainingRequestRepository.findAll();
        return Tools.mapListTrainingRequestToDtoList(trainingRequests);
    }

    @Override
    public List<TrainingRequestDto> getAllTrainingRequestByStatus(String status) {
        List<TrainingRequest> trainingRequests = trainingRequestRepository.findByStatus(Status.valueOf(status));
        return Tools.mapListTrainingRequestToDtoList(trainingRequests);
    }

    @Override
    public List<TrainingRequestDto> getTrainingRequestByTrainingProgramId(long trainingProgramId) {
        Optional<List<TrainingRequest>> optionalTrainingRequest = trainingRequestRepository.findByTrainingProgramTrainingProgramId(trainingProgramId);
        return optionalTrainingRequest.map(Tools::mapListTrainingRequestToDtoList).orElse(List.of());
    }

    @Override
    public List<TrainingRequestDto> getTrainingRequestByCandidateId(long candidateId) {
        List<TrainingRequest> trainingRequests = trainingRequestRepository.findByCandidateId(candidateId);
        return Tools.mapListTrainingRequestToDtoList(trainingRequests);
    }

    @Override
    public TrainingRequestDto createTrainingRequest(TrainingRequestDto trainingRequestDto) {
        TrainingProgram trainingProgram = Tools.mapTrainingProgramDtoToEntity(trainingProgramService.getTrainingProgram(trainingRequestDto.getTrainingProgram().getTrainingProgramId()));
        // URL for the external service (replace with actual URL)
        String url = hostServerCandidateManagement + "/candidate" + "/" + trainingRequestDto.getCandidateId();

        // Make the POST request to the external service
        ResponseEntity<CandidateDto> response = restTemplate.getForEntity(url, CandidateDto.class);

        // Return the response body
        CandidateDto candidateDto = response.getBody();

        if (candidateDto != null) {
            TrainingRequest trainingRequest = new TrainingRequest();
            trainingRequest.setRequestDate(trainingRequestDto.getRequestDate());
            trainingRequest.setStatus(Status.PENDING);
            trainingRequest.setCanceledDate(null);
            trainingRequest.setApprovedDate(null);
            trainingRequest.setTrainingProgram(trainingProgram);
            trainingRequest.setCandidateId(candidateDto.getIdCandidate());
            return (Tools.mapTrainingRequestToDto(trainingRequestRepository.save(trainingRequest)));
        } else {
            return new TrainingRequestDto();
        }
    }

    @Override
    public TrainingRequestDto updateTrainingRequest(TrainingRequestDto trainingRequestDto) {
        // URL for the external service (replace with actual URL)
        String url = hostServerCandidateManagement + "/candidate" + "/" + trainingRequestDto.getCandidateId();

        // Make the POST request to the external service
        ResponseEntity<CandidateDto> response = restTemplate.getForEntity(url, CandidateDto.class);

        // Return the response body
        CandidateDto candidateDto = response.getBody();

        if (candidateDto != null) {
            Optional<TrainingRequest> optionalTrainingRequest = trainingRequestRepository.findById(trainingRequestDto.getTrainingRequestId());
            if (optionalTrainingRequest.isPresent()) {
                TrainingRequest trainingRequest = optionalTrainingRequest.get();
                TrainingProgram trainingProgram = Tools.mapTrainingProgramDtoToEntity(trainingProgramService.getTrainingProgram(trainingRequestDto.getTrainingProgram().getTrainingProgramId()));
                trainingRequest.setRequestDate(trainingRequestDto.getRequestDate());
                trainingRequest.setStatus(Status.PENDING);
                trainingRequest.setCanceledDate(null);
                trainingRequest.setApprovedDate(null);
                trainingRequest.setTrainingProgram(trainingProgram);
                trainingRequest.setCandidateId(candidateDto.getIdCandidate());
                return (Tools.mapTrainingRequestToDto(trainingRequestRepository.save(trainingRequest)));
            } else {
                throw new RuntimeException("Training Request Not Found to update it ");
            }
        } else {
            throw new RuntimeException("Candidate Not Found");
        }
    }

    @Override
    public void deleteTrainingRequest(long trainingRequestId) {
        Optional<TrainingRequest> optionalTrainingRequest = trainingRequestRepository.findById(trainingRequestId);
        optionalTrainingRequest.ifPresent(trainingRequestRepository::delete);
    }

    @Override
    public List<TrainingRequestDto> getAllTrainingRequestsWhenDateBeetween(LocalDate startDate, LocalDate endDate) {
        List<TrainingRequest> trainingRequests = trainingRequestRepository.findAllByRequestDateBetween(startDate, endDate);
        return Tools.mapListTrainingRequestToDtoList(trainingRequests);
    }
}

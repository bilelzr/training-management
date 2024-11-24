package tn.pi.trainingmanagement.web;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.trainingmanagement.services.training_request.ITraningRequestService;
import tn.pi.trainingmanagement.tools.dtos.TrainingRequestDto;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/training-request")
public class TrainingRequestController {

    private final ITraningRequestService traningRequestService;

    public TrainingRequestController(ITraningRequestService traningRequestService) {
        this.traningRequestService = traningRequestService;
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllTrainingRequests() {
        return ResponseEntity.ok(traningRequestService.getAllTrainingRequests());
    }

    @GetMapping("/getByStatus/{status}")
    public ResponseEntity<?> getAllTrainingRequestByStatus(@PathVariable String status) {
        return ResponseEntity.ok(traningRequestService.getAllTrainingRequestByStatus(status));
    }

    @GetMapping("/getByTrainingProgram/{trainingProgramId}")
    public ResponseEntity<List<TrainingRequestDto>> getTrainingRequestByTrainingProgramId(@PathVariable("trainingProgramId") long trainingProgramId) {
        return ResponseEntity.ok(traningRequestService.getTrainingRequestByTrainingProgramId(trainingProgramId));
    }

    @GetMapping("/getByCandidate/{candidateId}")
    public ResponseEntity<List<TrainingRequestDto>> getTrainingRequestByCandidateId(@PathVariable long candidateId) {
        return ResponseEntity.ok(traningRequestService.getTrainingRequestByCandidateId(candidateId));
    }

    @PostMapping("new")
    public ResponseEntity<TrainingRequestDto> createTrainingRequest(@RequestBody TrainingRequestDto trainingRequestDto) {
        return ResponseEntity.ok(traningRequestService.createTrainingRequest(trainingRequestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<TrainingRequestDto> updateTrainingRequest(@RequestBody TrainingRequestDto trainingRequestDto) {
        return ResponseEntity.ok(traningRequestService.updateTrainingRequest(trainingRequestDto));
    }

    @DeleteMapping("/delete/{trainingRequestId}")
    public ResponseEntity<String> deleteTrainingRequest(@PathVariable long trainingRequestId) {
        traningRequestService.deleteTrainingRequest(trainingRequestId);
        return ResponseEntity.ok("training request deleted!");
    }

    @GetMapping("/getByDate")
    public ResponseEntity<?> getAllTrainingRequestsWhenDateBetween(@RequestParam("startDate") LocalDate startDate,
                                                                   @RequestParam("endDate") LocalDate endDate) {
        return ResponseEntity.ok(traningRequestService.getAllTrainingRequestsWhenDateBeetween(startDate, endDate));
    }
}

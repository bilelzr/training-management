package tn.pi.trainingmanagement.web;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.trainingmanagement.services.training_program.ITrainingProgramService;
import tn.pi.trainingmanagement.tools.dtos.TrainingProgramDto;

import java.util.List;

@RestController
@RequestMapping("/training-program")
public class TrainingProgramController {

    private final ITrainingProgramService trainingProgramService;

    public TrainingProgramController(ITrainingProgramService trainingProgramService) {
        this.trainingProgramService = trainingProgramService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TrainingProgramDto>> getAllTrainingPrograms() {
        return ResponseEntity.ok(trainingProgramService.getAllTrainingPrograms());
    }

    @GetMapping("/getById/{trainingProgramId}")
    public ResponseEntity<TrainingProgramDto> getTrainingProgram(@PathVariable long trainingProgramId) {
        return ResponseEntity.ok(trainingProgramService.getTrainingProgram(trainingProgramId));
    }


    @PostMapping("/new")
    public ResponseEntity<TrainingProgramDto> createTrainingProgram(@RequestBody TrainingProgramDto trainingProgramDto) {
        return ResponseEntity.ok(trainingProgramService.createTrainingProgram(trainingProgramDto));
    }

    @PutMapping("/update")
    public ResponseEntity<TrainingProgramDto> updateTrainingProgram(@RequestBody TrainingProgramDto trainingProgramDto) {
        return ResponseEntity.ok(trainingProgramService.updateTrainingProgram(trainingProgramDto));
    }


    @DeleteMapping("/delete/{trainingProgramId}")
    public ResponseEntity<String> deleteTrainingProgram(@PathVariable long trainingProgramId) {
        trainingProgramService.deleteTrainingProgram(trainingProgramId);
        return ResponseEntity.ok("Deleted training program");
    }

}

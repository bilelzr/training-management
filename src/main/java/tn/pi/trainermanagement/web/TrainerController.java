package tn.pi.trainermanagement.web;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.trainermanagement.services.trainer.ITrainerService;
import tn.pi.trainermanagement.tools.dtos.TrainerDto;

import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    private final ITrainerService trainerService;

    public TrainerController(ITrainerService trainerService) {
        this.trainerService = trainerService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<TrainerDto>> getAllTrainers() {
        return ResponseEntity.ok(trainerService.getAllTrainers());
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<TrainerDto> getTrainerByEmail(@PathVariable String email) {
        return ResponseEntity.ok(trainerService.getTrainerByEmail(email));
    }

    @GetMapping("/getById/{trainerId}")
    public ResponseEntity<TrainerDto> getTrainerById(@PathVariable long trainerId) {
        return ResponseEntity.ok(trainerService.getTrainerById(trainerId));
    }


    @PostMapping("/new")
    public ResponseEntity<TrainerDto> addTrainer(@RequestBody TrainerDto trainerDto) {
        return ResponseEntity.ok(trainerService.addTrainer(trainerDto));
    }

    @PutMapping("/update")
    public ResponseEntity<TrainerDto> updateTrainer(@RequestBody TrainerDto trainerDto) {
        return ResponseEntity.ok(trainerService.updateTrainer(trainerDto));
    }

    @DeleteMapping("/delete/{trainerId}")
    public ResponseEntity<String> deleteTrainer(long trainerId) {
        trainerService.deleteTrainer(trainerId);
        return ResponseEntity.ok("trainer deleted !");
    }


    @GetMapping("/getByFirstLastName")
    public ResponseEntity<TrainerDto> getTrainerByFirstLastName(@RequestParam("firstName") String firstName,
                                                                @RequestParam("lastName") String lastName) {
        return ResponseEntity.ok(trainerService.getTrainerByFirstLastName(firstName, lastName));
    }

}

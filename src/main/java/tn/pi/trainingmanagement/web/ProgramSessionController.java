package tn.pi.trainingmanagement.web;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.trainingmanagement.services.program_sessions.IProgramSessionService;
import tn.pi.trainingmanagement.tools.dtos.ProgramSessionDto;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/session")
public class ProgramSessionController {

    private final IProgramSessionService sessionService;

    public ProgramSessionController(IProgramSessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProgramSessionDto>> getAllProgramSessions() {
        return ResponseEntity.ok(sessionService.getAllProgramSessions());
    }

    @GetMapping("/getByTrainingProgram/{trainingProgramId}")
    public ResponseEntity<List<ProgramSessionDto>> getProgramSessionsByTrainingProgramId(@PathVariable long trainingProgramId) {
        return ResponseEntity.ok(sessionService.getProgramSessionsByTrainingProgramId(trainingProgramId));
    }

    @GetMapping("/getById/{sessionId}")
    public ResponseEntity<ProgramSessionDto> getProgramSessionById(@PathVariable long sessionId) {
        return ResponseEntity.ok(sessionService.getProgramSessionById(sessionId));
    }

    @PostMapping("/new")
    public ResponseEntity<ProgramSessionDto> createProgramSession(@RequestBody ProgramSessionDto programSessionDto) {
        return ResponseEntity.ok(sessionService.createProgramSession(programSessionDto));
    }

    @PutMapping("/update")
    public ResponseEntity<ProgramSessionDto> updateProgramSession(@RequestBody ProgramSessionDto programSessionDto) {
        return ResponseEntity.ok(sessionService.updateProgramSession(programSessionDto));
    }

    @DeleteMapping("/delete/{programSessionId}")
    public ResponseEntity<String> deleteProgramSession(@PathVariable long programSessionId) {
        sessionService.deleteProgramSession(programSessionId);
        return ResponseEntity.ok("program session deleted!");
    }

    @GetMapping("/getByTrainingProgramAndDateBetween/{trainingProgramId}")
    public ResponseEntity<ProgramSessionDto> getProgramSessionByTrainingProgramIdAndSessionDateBetween(@PathVariable long trainingProgramId,
                                                                                                       @RequestParam("startDate") LocalDate startDate,
                                                                                                       @RequestParam("endDate") LocalDate endDate) {
        return ResponseEntity.ok(sessionService.getProgramSessionByTrainingProgramIdAndSessionDateBetween(trainingProgramId, startDate, endDate));
    }


}

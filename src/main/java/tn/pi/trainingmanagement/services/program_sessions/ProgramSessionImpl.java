package tn.pi.trainingmanagement.services.program_sessions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tn.pi.trainingmanagement.entities.ProgramSession;
import tn.pi.trainingmanagement.repositories.ProgramSessionRepository;
import tn.pi.trainingmanagement.tools.Tools;
import tn.pi.trainingmanagement.tools.dtos.ProgramSessionDto;
import tn.pi.trainingmanagement.tools.dtos.externalDtos.TrainerDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class ProgramSessionImpl implements IProgramSessionService {
    private final ProgramSessionRepository programSessionRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProgramSessionImpl.class);

    public ProgramSessionImpl(ProgramSessionRepository programSessionRepository) {
        this.programSessionRepository = programSessionRepository;
    }

    @Override
    public List<ProgramSessionDto> getAllProgramSessions() {
        List<ProgramSession> programSessions = programSessionRepository.findAll();
        return Tools.mapListProgramSessionToDtoList(programSessions);
    }

    @Override
    public List<ProgramSessionDto> getProgramSessionsByTrainingProgramId(long trainingProgramId) {
        List<ProgramSession> programSessions = programSessionRepository.findByTrainingProgramTrainingProgramId(trainingProgramId);
        return Tools.mapListProgramSessionToDtoList(programSessions);
    }

    @Override
    public ProgramSessionDto getProgramSessionById(long sessionId) {
        Optional<ProgramSession> programSession = programSessionRepository.findById(sessionId);
        return programSession.map(Tools::mapProgramSessionToDto).orElse(null);

    }

    @Override
    public ProgramSessionDto createProgramSession(ProgramSessionDto programSessionDto) {
        ProgramSession programSession = new ProgramSession();
        if (!isTrainerExists(programSessionDto.getTrainerFk())) {
            throw new IllegalArgumentException("trainer does not exists");
        }
        programSession.setSessionDate(programSessionDto.getSessionDate());
        programSession.setTrainingProgram(Tools.mapTrainingProgramDtoToEntity(programSessionDto.getTrainingProgram()));
        programSession.setSessionTitle(programSessionDto.getSessionTitle());
        programSession.setSessionStartTime(programSessionDto.getSessionStartTime());
        programSession.setSessionEndTime(programSessionDto.getSessionEndTime());
        programSession.setTrainerFk(programSessionDto.getTrainerFk());
        programSession.setCreatedAt(LocalDateTime.now());
        return Tools.mapProgramSessionToDto(programSessionRepository.save(programSession));
    }

    @Override
    public ProgramSessionDto updateProgramSession(ProgramSessionDto programSessionDto) {
        Optional<ProgramSession> optionalProgramSession = programSessionRepository.findById(programSessionDto.getProgramSessionId());

        if (optionalProgramSession.isPresent() && isTrainerExists(programSessionDto.getTrainerFk())) {
            ProgramSession programSession = optionalProgramSession.get();
            programSession.setSessionDate(programSessionDto.getSessionDate());
            programSession.setTrainingProgram(Tools.mapTrainingProgramDtoToEntity(programSessionDto.getTrainingProgram()));
            programSession.setSessionTitle(programSessionDto.getSessionTitle());
            programSession.setSessionStartTime(programSessionDto.getSessionStartTime());
            programSession.setSessionEndTime(programSessionDto.getSessionEndTime());
            programSession.setTrainerFk(programSessionDto.getTrainerFk()); // TODO : Call restTemplate Here from training module
            programSession.setCreatedAt(LocalDateTime.now());
            return Tools.mapProgramSessionToDto(programSessionRepository.save(programSession));
        }
        throw new IllegalArgumentException("Program session not found or trainer not found");

    }

    @Override
    public void deleteProgramSession(long sessionId) {
        Optional<ProgramSession> optionalProgramSession = programSessionRepository.findById(sessionId);
        if (optionalProgramSession.isPresent()) {
            ProgramSession programSession = optionalProgramSession.get();
            programSessionRepository.delete(programSession);
        } else {
            throw new IllegalArgumentException("Program session not found");
        }
    }

    @Override
    public ProgramSessionDto getProgramSessionByTrainingProgramIdAndSessionDateBetween(long trainingProgramId, LocalDate startTime, LocalDate endTime) {
        ProgramSession programSession = programSessionRepository.findByTrainingProgramTrainingProgramIdAndSessionDateBetween(trainingProgramId, startTime, endTime);
        return Tools.mapProgramSessionToDto(programSession);
    }


    public boolean isTrainerExists(long trainerFk) {
        // URL of the REST API
        logger.error("calling trainer management service to check either the trainer exists or not");

        String apiUrl = "http://127.0.0.1:8222/internal-management/trainer/getById/" + trainerFk;
        // Build WebClient instance
        WebClient webClient = WebClient.create();

        try {
            // Perform GET request and block to get response synchronously
            TrainerDto response = webClient.get()
                    .uri(apiUrl, trainerFk)
                    .retrieve()
                    .bodyToMono(TrainerDto.class)
                    .block(); // Block to convert reactive Mono to a concrete value
            return response != null && response.getTrainerId() != 0;
        } catch (Exception e) {
            // Handle exception (e.g., logging)
            logger.error("an exception have been thrown {}", e.getMessage());
            return false;
        }
    }

}

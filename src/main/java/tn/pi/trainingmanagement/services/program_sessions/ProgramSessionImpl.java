package tn.pi.trainingmanagement.services.program_sessions;

import org.springframework.stereotype.Service;
import tn.pi.trainingmanagement.entities.ProgramSession;
import tn.pi.trainingmanagement.repositories.ProgramSessionRepository;
import tn.pi.trainingmanagement.tools.Tools;
import tn.pi.trainingmanagement.tools.dtos.ProgramSessionDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramSessionImpl implements IProgramSessionService {
    private final ProgramSessionRepository programSessionRepository;

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
        programSession.setSessionDate(programSessionDto.getSessionDate());
        programSession.setTrainingProgram(Tools.mapTrainingProgramDtoToEntity(programSessionDto.getTrainingProgram()));
        programSession.setSessionTitle(programSessionDto.getSessionTitle());
        programSession.setSessionStartTime(programSessionDto.getSessionStartTime());
        programSession.setSessionEndTime(programSessionDto.getSessionEndTime());
        programSession.setTrainerFk(programSessionDto.getTrainerFk()); // TODO : Call restTemplate Here from training module
        programSession.setCreatedAt(LocalDateTime.now());
        return Tools.mapProgramSessionToDto(programSessionRepository.save(programSession));
    }

    @Override
    public ProgramSessionDto updateProgramSession(ProgramSessionDto programSessionDto) {
        Optional<ProgramSession> optionalProgramSession = programSessionRepository.findById(programSessionDto.getProgramSessionId());
        if (optionalProgramSession.isPresent()) {
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
        throw new IllegalArgumentException("Program session not found");

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
        ProgramSession programSession = programSessionRepository.findByTrainingProgramTrainingProgramIdAndSessionDateBetween(trainingProgramId,startTime,endTime);
        return Tools.mapProgramSessionToDto(programSession);
    }
}

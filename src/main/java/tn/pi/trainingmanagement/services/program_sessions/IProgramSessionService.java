package tn.pi.trainingmanagement.services.program_sessions;

import tn.pi.trainingmanagement.tools.dtos.ProgramSessionDto;

import java.time.LocalDate;
import java.util.List;



public interface IProgramSessionService {

    List<ProgramSessionDto> getAllProgramSessions();

    List<ProgramSessionDto> getProgramSessionsByTrainingProgramId(long trainingProgramId);

    ProgramSessionDto getProgramSessionById(long sessionId);

    ProgramSessionDto createProgramSession(ProgramSessionDto programSessionDto);

    ProgramSessionDto updateProgramSession(ProgramSessionDto programSessionDto);

    void deleteProgramSession(long sessionId);

    ProgramSessionDto getProgramSessionByTrainingProgramIdAndSessionDateBetween(long trainingProgramId, LocalDate startDate, LocalDate endDate);
}

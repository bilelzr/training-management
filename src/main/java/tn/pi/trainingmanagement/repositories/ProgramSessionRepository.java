package tn.pi.trainingmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pi.trainingmanagement.entities.ProgramSession;

import java.time.LocalDate;
import java.util.List;

public interface ProgramSessionRepository extends JpaRepository<ProgramSession,Long> {
    List<ProgramSession> findByTrainingProgramTrainingProgramId(long trainingProgramId);

    ProgramSession findByTrainingProgramTrainingProgramIdAndSessionDateBetween(long trainingProgramId,LocalDate startDate,LocalDate endDate);
}

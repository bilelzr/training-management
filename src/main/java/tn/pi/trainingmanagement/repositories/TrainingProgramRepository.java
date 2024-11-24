package tn.pi.trainingmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.trainingmanagement.entities.TrainingProgram;

@Repository
public interface TrainingProgramRepository extends JpaRepository<TrainingProgram, Long> {
}

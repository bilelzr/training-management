package tn.pi.trainingmanagement.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.trainingmanagement.entities.Status;
import tn.pi.trainingmanagement.entities.TrainingRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingRequestRepository extends JpaRepository<TrainingRequest, Long> {


    List<TrainingRequest> findAllByRequestDateBetween(LocalDate from, LocalDate to);

    List<TrainingRequest> findByCandidateId(long candidateId);

    List<TrainingRequest> findByStatus(Status status);


    Optional<List<TrainingRequest>> findByTrainingProgramTrainingProgramId(long trainingProgramId);
}

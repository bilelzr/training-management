package tn.pi.trainermanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.trainermanagement.entities.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
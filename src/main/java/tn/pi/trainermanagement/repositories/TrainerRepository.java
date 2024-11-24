package tn.pi.trainermanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.trainermanagement.entities.Trainer;

import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Optional<Trainer> findByEmail(String email);

    Optional<Trainer> findByFirstNameAndLastName(String firstName, String lastName);
}

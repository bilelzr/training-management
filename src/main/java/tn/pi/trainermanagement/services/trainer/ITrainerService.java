package tn.pi.trainermanagement.services.trainer;

import tn.pi.trainermanagement.tools.dtos.TrainerDto;

import java.util.List;

public interface ITrainerService {

    List<TrainerDto> getAllTrainers();

    TrainerDto getTrainerByEmail(String email);

    TrainerDto getTrainerById(long id);

    TrainerDto addTrainer(TrainerDto trainerDto);

    TrainerDto updateTrainer(TrainerDto trainerDto);

    void deleteTrainer(long id);

    TrainerDto getTrainerByFirstLastName(String firstName, String lastName);
}

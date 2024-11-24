package tn.pi.trainermanagement.services.trainer;

import org.springframework.stereotype.Service;
import tn.pi.trainermanagement.repositories.TrainerRepository;
import tn.pi.trainermanagement.tools.dtos.TrainerDto;

import java.util.List;

@Service
public class TrainingServiceImpl implements ITrainerService {


    private final TrainerRepository trainerRepository;

    public TrainingServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }


    @Override
    public List<TrainerDto> getAllTrainers() {
        return List.of();
    }

    @Override
    public TrainerDto getTrainerByEmail(String email) {
        return null;
    }

    @Override
    public TrainerDto getTrainerById(long id) {
        return null;
    }

    @Override
    public TrainerDto addTrainer(TrainerDto candidate) {
        return null;
    }

    @Override
    public TrainerDto updateTrainer(TrainerDto candidate) {
        return null;
    }

    @Override
    public void deleteTrainer(long id) {

    }

    @Override
    public TrainerDto getTrainerByFirstLastName(String firstName, String lastName) {
        return null;
    }
}

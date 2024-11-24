package tn.pi.trainermanagement.services.trainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tn.pi.trainermanagement.entities.Trainer;
import tn.pi.trainermanagement.repositories.TrainerRepository;
import tn.pi.trainermanagement.tools.Tools;
import tn.pi.trainermanagement.tools.dtos.TrainerDto;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingServiceImpl implements ITrainerService {


    private static final Logger logger = LoggerFactory.getLogger(ITrainerService.class);


    private final TrainerRepository trainerRepository;

    public TrainingServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }


    @Override
    public List<TrainerDto> getAllTrainers() {
        List<Trainer> trainers = trainerRepository.findAll();
        return Tools.mapListTrainerToDto(trainers);
    }

    @Override
    public TrainerDto getTrainerByEmail(String email) {
        Optional<Trainer> optionalTrainer = trainerRepository.findByEmail(email);
        return optionalTrainer.map(Tools::mapTrainerToDto).orElse(null);
    }

    @Override
    public TrainerDto getTrainerById(long id) {
        Optional<Trainer> optionalTrainer = trainerRepository.findById(id);
        return optionalTrainer.map(Tools::mapTrainerToDto).orElse(null);
    }

    @Override
    public TrainerDto addTrainer(TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
        try {
            trainer.setEmail(trainerDto.getEmail());
            trainer.setAge(trainerDto.getAge());
            trainer.setStatus(trainerDto.getStatus());
            trainer.setFirstName(trainerDto.getFirstName());
            trainer.setGender(trainer.getGender());
            trainer.setPhone(trainerDto.getPhone());
            trainer.setLastName(trainerDto.getLastName());
            trainer.setLevel(trainerDto.getLevel());
            trainer.setProfession(trainerDto.getProfession());
            trainer.setDepartment(trainerDto.getDepartment());
            trainerRepository.save(trainer);
        } catch (Exception e) {
            logger.error("error while creating trainer {}", e.getMessage());
            return null;
        }
        return trainerDto;
    }

    @Override
    public TrainerDto updateTrainer(TrainerDto trainerDto) {
        Optional<Trainer> optionalTrainer = trainerRepository.findById(trainerDto.getTrainerId());
        if (optionalTrainer.isPresent()) {
            Trainer trainer = optionalTrainer.get();
            trainer.setEmail(trainerDto.getEmail());
            trainer.setAge(trainerDto.getAge());
            trainer.setDepartment(trainer.getDepartment());
            trainer.setStatus(trainerDto.getStatus());
            trainer.setFirstName(trainerDto.getFirstName());
            trainer.setGender(trainer.getGender());
            trainer.setPhone(trainerDto.getPhone());
            trainer.setLastName(trainerDto.getLastName());
            trainer.setLevel(trainerDto.getLevel());
            trainer.setProfession(trainerDto.getProfession());
            trainerRepository.save(trainer);
        }
        return trainerDto;
    }

    @Override
    public void deleteTrainer(long id) {
        Optional<Trainer> optionalTrainer = trainerRepository.findById(id);
        optionalTrainer.ifPresent(trainerRepository::delete);
    }

    @Override
    public TrainerDto getTrainerByFirstLastName(String firstName, String lastName) {
        Optional<Trainer> trainer = trainerRepository.findByFirstNameAndLastName(firstName, lastName);
        return trainer.map(Tools::mapTrainerToDto).orElse(null);
    }
}

package tn.pi.trainingmanagement.services.training_program;

import org.springframework.stereotype.Service;
import tn.pi.trainingmanagement.entities.TrainingProgram;
import tn.pi.trainingmanagement.repositories.TrainingProgramRepository;
import tn.pi.trainingmanagement.tools.Tools;
import tn.pi.trainingmanagement.tools.dtos.TrainingProgramDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class TrainingProgramServiceImpl implements ITrainingProgramService {


    private final TrainingProgramRepository trainingProgramRepository;


    public TrainingProgramServiceImpl(TrainingProgramRepository trainingProgramRepository) {
        this.trainingProgramRepository = trainingProgramRepository;
    }

    @Override
    public TrainingProgramDto getTrainingProgram(long id) {
        Optional<TrainingProgram> trainingProgram = trainingProgramRepository.findById(id);
        return trainingProgram.map(Tools::mapTraingingProgramToDto).orElse(null);
    }

    @Override
    public List<TrainingProgramDto> getAllTrainingPrograms() {
        List<TrainingProgram> trainingPrograms = trainingProgramRepository.findAll();
        return Tools.mapTraingingProgramListToDtoList(trainingPrograms);
    }

    @Override
    public TrainingProgramDto createTrainingProgram(TrainingProgramDto trainingProgram) {

        TrainingProgram trainingProgramToBeSaved = new TrainingProgram();
        trainingProgramToBeSaved.setProgramDescription(trainingProgram.getProgramDescription());
        trainingProgramToBeSaved.setProgramName(trainingProgram.getProgramName());
        trainingProgramToBeSaved.setCreatedAt(LocalDateTime.now());
        trainingProgramToBeSaved.setStartDate(trainingProgram.getStartDate());
        trainingProgramToBeSaved.setEndDate(trainingProgram.getEndDate());
        trainingProgramToBeSaved.setThemeList(Tools.mapThemeDtoListToEntityList(trainingProgram.getThemeList()));
        return Tools.mapTraingingProgramToDto(trainingProgramRepository.save(trainingProgramToBeSaved));
    }

    @Override
    public TrainingProgramDto updateTrainingProgram(TrainingProgramDto trainingProgramDto) {
        Optional<TrainingProgram> trainingProgram = trainingProgramRepository.findById(trainingProgramDto.getTrainingProgramId());
        if (trainingProgram.isPresent()) {
            TrainingProgram trainingProgramToBeUpdated = trainingProgram.get();
            trainingProgramToBeUpdated.setProgramDescription(trainingProgramDto.getProgramDescription());
            trainingProgramToBeUpdated.setProgramName(trainingProgramDto.getProgramName());
            trainingProgramToBeUpdated.setCreatedAt(LocalDateTime.now());
            trainingProgramToBeUpdated.setStartDate(trainingProgramDto.getStartDate());
            trainingProgramToBeUpdated.setEndDate(trainingProgramDto.getEndDate());
            trainingProgramToBeUpdated.setThemeList(Tools.mapThemeDtoListToEntityList(trainingProgramDto.getThemeList()));
            return Tools.mapTraingingProgramToDto(trainingProgramRepository.save(trainingProgramToBeUpdated));
        }
        return null;
    }

    @Override
    public void deleteTrainingProgram(long id) {
        Optional<TrainingProgram> trainingProgram = trainingProgramRepository.findById(id);
        trainingProgram.ifPresent(trainingProgramRepository::delete);
    }
}

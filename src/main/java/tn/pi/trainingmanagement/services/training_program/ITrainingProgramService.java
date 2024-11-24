package tn.pi.trainingmanagement.services.training_program;

import tn.pi.trainingmanagement.entities.TrainingProgram;
import tn.pi.trainingmanagement.tools.dtos.TrainingProgramDto;

import java.util.List;

public interface ITrainingProgramService {

    TrainingProgramDto getTrainingProgram(long id);

    List<TrainingProgramDto> getAllTrainingPrograms();

    TrainingProgramDto createTrainingProgram(TrainingProgramDto trainingProgram);

    TrainingProgramDto updateTrainingProgram(TrainingProgramDto trainingProgram);

    void deleteTrainingProgram(long id);
}

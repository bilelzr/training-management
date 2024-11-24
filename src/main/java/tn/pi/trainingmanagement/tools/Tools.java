package tn.pi.trainingmanagement.tools;

import org.hibernate.LazyInitializationException;
import tn.pi.trainingmanagement.entities.ProgramSession;
import tn.pi.trainingmanagement.entities.Theme;
import tn.pi.trainingmanagement.entities.TrainingProgram;
import tn.pi.trainingmanagement.entities.TrainingRequest;
import tn.pi.trainingmanagement.tools.dtos.ProgramSessionDto;
import tn.pi.trainingmanagement.tools.dtos.ThemeDto;
import tn.pi.trainingmanagement.tools.dtos.TrainingProgramDto;
import tn.pi.trainingmanagement.tools.dtos.TrainingRequestDto;

import java.util.ArrayList;
import java.util.List;

public class Tools {

    private Tools() {

    }

    public static ThemeDto mapThemeToDto(Theme theme) {
        return ThemeDto.builder()
                .themeDescription(theme.getThemeDescription())
                .themeName(theme.getThemeName())
                .createdAt(theme.getCreatedAt())
                .build();
    }

    public static List<ThemeDto> mapThemeListToDtoList(List<Theme> themes) {
        List<ThemeDto> themeDtoList = new ArrayList<>();
        themes.forEach(theme -> {
            themeDtoList.add(mapThemeToDto(theme));
        });
        return themeDtoList;
    }

    public static TrainingProgramDto mapTraingingProgramToDto(TrainingProgram program) {
        return TrainingProgramDto.builder()
                .programDescription(program.getProgramDescription())
                .programName(program.getProgramName())
                .startDate(program.getStartDate())
                .endDate(program.getEndDate())
                .themeList(getThemeList(program))
                .createdAt(program.getCreatedAt())
                .trainingProgramId(program.getTrainingProgramId())
                .build();
    }

    public static List<TrainingProgramDto> mapTraingingProgramListToDtoList(List<TrainingProgram> programs) {
        List<TrainingProgramDto> programDtoList = new ArrayList<>();
        programs.forEach(program -> {
            programDtoList.add(mapTraingingProgramToDto(program));
        });
        return programDtoList;
    }

    public static TrainingRequestDto mapTrainingRequestToDto(TrainingRequest request) {
        return TrainingRequestDto.builder()
                .candidateId(request.getCandidateId())
                .requestDate(request.getRequestDate())
                .trainingProgram(mapTraingingProgramToDto(request.getTrainingProgram()))
                .canceledDate(request.getCanceledDate())
                .approvedDate(request.getApprovedDate())
                .status(request.getStatus())
                .build();
    }

    public static List<TrainingRequestDto> mapListTrainingRequestToDtoList(List<TrainingRequest> requests) {
        List<TrainingRequestDto> requestDtoList = new ArrayList<>();
        requests.forEach(request -> {
            requestDtoList.add(mapTrainingRequestToDto(request));
        });
        return requestDtoList;
    }

    public static ProgramSessionDto mapProgramSessionToDto(ProgramSession programSession) {
        return ProgramSessionDto.builder()
                .programSessionId(programSession.getProgramSessionId())
                .sessionDate(programSession.getSessionDate())
                .sessionEndTime(programSession.getSessionEndTime())
                .sessionStartTime(programSession.getSessionStartTime())
                .sessionTitle(programSession.getSessionTitle())
                .trainingProgram(mapTraingingProgramToDto(programSession.getTrainingProgram()))
                .trainerFk(programSession.getTrainerFk())
                .build();
    }

    public static List<ProgramSessionDto> mapListProgramSessionToDtoList(List<ProgramSession> programSessions) {
        List<ProgramSessionDto> programSessionDtoList = new ArrayList<>();
        programSessions.forEach(programSession -> {
            programSessionDtoList.add(mapProgramSessionToDto(programSession));
        });
        return programSessionDtoList;
    }

    public static Theme mapThemeDtoToEntity(ThemeDto themeDto) {
        Theme theme = new Theme();
        theme.setThemeId(themeDto.getThemeId());
        theme.setThemeDescription(themeDto.getThemeDescription());
        theme.setThemeName(themeDto.getThemeName());
        theme.setCreatedAt(themeDto.getCreatedAt());
        return theme;
    }

    public static List<Theme> mapThemeDtoListToEntityList(List<ThemeDto> themeDtos) {
        List<Theme> themes = new ArrayList<>();
        themeDtos.forEach(themeDto -> {
            themes.add(mapThemeDtoToEntity(themeDto));
        });
        return themes;
    }

    public static TrainingProgram mapTrainingProgramDtoToEntity(TrainingProgramDto trainingProgramDto) {
        TrainingProgram program = new TrainingProgram();
        program.setProgramDescription(trainingProgramDto.getProgramDescription());
        program.setProgramName(trainingProgramDto.getProgramName());
        program.setStartDate(trainingProgramDto.getStartDate());
        program.setEndDate(trainingProgramDto.getEndDate());
        if(trainingProgramDto.getThemeList()!= null){
            program.setThemeList(mapThemeDtoListToEntityList(trainingProgramDto.getThemeList()));
        }
        program.setTrainingProgramId(trainingProgramDto.getTrainingProgramId());
        return program;
    }

    public static List<TrainingProgram> mapTrainingProgramDtoListToEntityList(List<TrainingProgramDto> trainingProgramDtos) {
        List<TrainingProgram> programs = new ArrayList<>();
        trainingProgramDtos.forEach(trainingProgramDto -> {
            programs.add(mapTrainingProgramDtoToEntity(trainingProgramDto));
        });
        return programs;
    }

    public static TrainingRequest mapTrainingRequestDtoToEntity(TrainingRequestDto trainingRequestDto) {
        TrainingRequest request = new TrainingRequest();
        request.setCandidateId(trainingRequestDto.getCandidateId());
        request.setRequestDate(trainingRequestDto.getRequestDate());
        request.setTrainingProgram(mapTrainingProgramDtoToEntity(trainingRequestDto.getTrainingProgram()));
        request.setCanceledDate(trainingRequestDto.getCanceledDate());
        request.setApprovedDate(trainingRequestDto.getApprovedDate());
        request.setStatus(trainingRequestDto.getStatus());
        return request;
    }

    public static List<TrainingRequest> mapTrainingRequestDtoListToEntityList(List<TrainingRequestDto> trainingRequestDtos) {
        List<TrainingRequest> requests = new ArrayList<>();
        trainingRequestDtos.forEach(trainingRequestDto -> {
            requests.add(mapTrainingRequestDtoToEntity(trainingRequestDto));
        });
        return requests;
    }

    public static ProgramSession mapProgramSessionDtoToEntity(ProgramSessionDto programSessionDto) {
        ProgramSession programSession = new ProgramSession();
        programSession.setProgramSessionId(programSessionDto.getProgramSessionId());
        programSession.setSessionDate(programSessionDto.getSessionDate());
        programSession.setSessionEndTime(programSessionDto.getSessionEndTime());
        programSession.setSessionStartTime(programSessionDto.getSessionStartTime());
        programSession.setSessionTitle(programSessionDto.getSessionTitle());
        programSession.setTrainingProgram(mapTrainingProgramDtoToEntity(programSessionDto.getTrainingProgram()));
        programSession.setTrainerFk(programSessionDto.getTrainerFk());
        return programSession;
    }

    public static List<ProgramSession> mapProgramSessionDtoListToEntityList(List<ProgramSessionDto> programSessionDtos) {
        List<ProgramSession> programSessions = new ArrayList<>();
        programSessionDtos.forEach(programSessionDto -> {
            programSessions.add(mapProgramSessionDtoToEntity(programSessionDto));
        });
        return programSessions;
    }
    private static List<ThemeDto> getThemeList(TrainingProgram program) {
        try {
            return program.getThemeList() != null ? mapThemeListToDtoList(program.getThemeList()) : new ArrayList<>();
        } catch (LazyInitializationException e) {
            // Log the exception or handle as needed
            return new ArrayList<>();
        }
    }
}

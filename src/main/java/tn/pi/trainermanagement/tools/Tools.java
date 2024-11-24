package tn.pi.trainermanagement.tools;

import tn.pi.trainermanagement.entities.Equipement;
import tn.pi.trainermanagement.entities.EquipementType;
import tn.pi.trainermanagement.entities.Trainer;
import tn.pi.trainermanagement.tools.dtos.EquipementDto;
import tn.pi.trainermanagement.tools.dtos.EquipementTypeDto;
import tn.pi.trainermanagement.tools.dtos.TrainerDto;

import java.util.ArrayList;
import java.util.List;

public class Tools {

    public static EquipementDto mapEquipementDto(Equipement equipement) {
        return EquipementDto.builder()
                .equipementType(mapEquipementTypeDto(equipement.getEquipementType()))
                .equipementId(equipement.getEquipementId())
                .equipementStatus(equipement.getEquipementStatus())
                .equipementName(equipement.getEquipementName())
                .equipementDescription(equipement.getEquipementDescription())
                .build();
    }

    public static List<EquipementDto> mapListEquipementToDto(List<Equipement> equipements) {
        List<EquipementDto> equipementDtos = new ArrayList<>();
        equipements.forEach(equipement -> {
            equipementDtos.add(mapEquipementDto(equipement));
        });
        return equipementDtos;
    }

    public static EquipementTypeDto mapEquipementTypeDto(EquipementType equipementType) {
        return EquipementTypeDto.builder()
                .equipementTypeId(equipementType.getEquipementTypeId())
                .specificNumber(equipementType.getSpecificNumber())
                .isSpecificNumber(equipementType.isSpecificNumber())
                .hasCapacity(equipementType.isHasCapacity())
                .typeName(equipementType.getTypeName())
                .capacity(equipementType.getCapacity())
                .build();
    }

    public static List<EquipementTypeDto> mapListEquipementTypeToDto(List<EquipementType> equipementTypes) {
        List<EquipementTypeDto> equipementTypeDtos = new ArrayList<>();
        equipementTypes.forEach(equipementType -> {
            equipementTypeDtos.add(mapEquipementTypeDto(equipementType));
        });
        return equipementTypeDtos;
    }

    public static TrainerDto mapTrainerToDto(Trainer trainer) {
        return TrainerDto.builder()
                .trainerId(trainer.getTrainerId())
                .email(trainer.getEmail())
                .level(trainer.getLevel())
                .phone(trainer.getPhone())
                .age(trainer.getAge())
                .firstName(trainer.getFirstName())
                .lastName(trainer.getLastName())
                .profession(trainer.getProfession())
                .gender(trainer.getGender())
                .status(trainer.getStatus())
                .department(trainer.getDepartment())
                .build();
    }

    public static List<TrainerDto> mapListTrainerToDto(List<Trainer> trainers) {
        List<TrainerDto> trainerDtos = new ArrayList<>();
        trainers.forEach(trainer -> {
            trainerDtos.add(mapTrainerToDto(trainer));
        });
        return trainerDtos;
    }


}

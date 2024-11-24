package tn.pi.trainermanagement.tools.dtos;

import jakarta.persistence.*;
import lombok.Builder;
import tn.pi.trainermanagement.entities.EquipementStatus;
import tn.pi.trainermanagement.entities.EquipementType;

@Builder
public class EquipementDto {

    private long equipementId;
    private String equipementName;
    private String equipementDescription;
    private EquipementTypeDto equipementType;
    private EquipementStatus equipementStatus;

    public EquipementDto() {
    }

    public EquipementDto(long equipementId, String equipementName, String equipementDescription, EquipementTypeDto equipementType, EquipementStatus equipementStatus) {
        this.equipementId = equipementId;
        this.equipementName = equipementName;
        this.equipementDescription = equipementDescription;
        this.equipementType = equipementType;
        this.equipementStatus = equipementStatus;
    }

    public long getEquipementId() {
        return equipementId;
    }

    public void setEquipementId(long equipementId) {
        this.equipementId = equipementId;
    }

    public String getEquipementName() {
        return equipementName;
    }

    public void setEquipementName(String equipementName) {
        this.equipementName = equipementName;
    }

    public String getEquipementDescription() {
        return equipementDescription;
    }

    public void setEquipementDescription(String equipementDescription) {
        this.equipementDescription = equipementDescription;
    }

    public EquipementTypeDto getEquipementType() {
        return equipementType;
    }

    public void setEquipementType(EquipementTypeDto equipementType) {
        this.equipementType = equipementType;
    }

    public EquipementStatus getEquipementStatus() {
        return equipementStatus;
    }

    public void setEquipementStatus(EquipementStatus equipementStatus) {
        this.equipementStatus = equipementStatus;
    }
}

package tn.pi.trainermanagement.tools.dtos;

import lombok.Builder;

import java.util.List;

@Builder
public class EquipementTypeDto {


    private long equipementTypeId;
    private String typeName;
    private boolean hasCapacity;
    private long capacity;
    private boolean isSpecificNumber;
    private long specificNumber;
    private List<EquipementDto> equipements;

    public EquipementTypeDto() {
    }

    public EquipementTypeDto(long equipementTypeId, String typeName, boolean hasCapacity, long capacity, boolean isSpecificNumber, long specificNumber, List<EquipementDto> equipements) {
        this.equipementTypeId = equipementTypeId;
        this.typeName = typeName;
        this.hasCapacity = hasCapacity;
        this.capacity = capacity;
        this.isSpecificNumber = isSpecificNumber;
        this.specificNumber = specificNumber;
        this.equipements = equipements;
    }

    public long getEquipementTypeId() {
        return equipementTypeId;
    }

    public void setEquipementTypeId(long equipementTypeId) {
        this.equipementTypeId = equipementTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean isHasCapacity() {
        return hasCapacity;
    }

    public void setHasCapacity(boolean hasCapacity) {
        this.hasCapacity = hasCapacity;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public boolean isSpecificNumber() {
        return isSpecificNumber;
    }

    public void setSpecificNumber(boolean specificNumber) {
        isSpecificNumber = specificNumber;
    }

    public long getSpecificNumber() {
        return specificNumber;
    }

    public void setSpecificNumber(long specificNumber) {
        this.specificNumber = specificNumber;
    }

    public List<EquipementDto> getEquipements() {
        return equipements;
    }

    public void setEquipements(List<EquipementDto> equipements) {
        this.equipements = equipements;
    }
}

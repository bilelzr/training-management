package tn.pi.trainermanagement.entities;

import jakarta.persistence.*;

import java.util.List;

@Table
@Entity(name = "equipementType")
public class EquipementType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipement_type_seq")
    @SequenceGenerator(name = "equipement_type_seq", sequenceName = "equipement_type_sequence", allocationSize = 1)
    @Column(name = "equipement_type_id")
    private long equipementTypeId;

    private String typeName;
    private boolean hasCapacity;
    private long capacity;
    private boolean isSpecificNumber;
    private long specificNumber;
    @OneToMany(mappedBy = "equipementType")
    private List<Equipement> equipements;


    public EquipementType() {
    }

    public EquipementType(long equipementTypeId, String typeName, boolean hasCapacity, long capacity, boolean isSpecificNumber, long specificNumber, List<Equipement> equipements) {
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

    public List<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(List<Equipement> equipements) {
        this.equipements = equipements;
    }
}

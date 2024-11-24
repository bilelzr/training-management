package tn.pi.trainermanagement.entities;


import jakarta.persistence.*;

@Table
@Entity(name = "equipement")
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainer_seq")
    @SequenceGenerator(name = "equipement_seq", sequenceName = "equipement_sequence", allocationSize = 1)
    private long equipementId;
    private String equipementName;
    private String equipementDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipement_type_id", insertable = false, updatable = false)
    private EquipementType equipementType;
    private EquipementStatus equipementStatus;

    public Equipement() {
    }

    public Equipement(long equipementId, String equipementName, String equipementDescription, EquipementType equipementType, EquipementStatus equipementStatus) {
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

    public EquipementType getEquipementType() {
        return equipementType;
    }

    public void setEquipementType(EquipementType equipementType) {
        this.equipementType = equipementType;
    }

    public EquipementStatus getEquipementStatus() {
        return equipementStatus;
    }

    public void setEquipementStatus(EquipementStatus equipementStatus) {
        this.equipementStatus = equipementStatus;
    }
}

package tn.pi.trainermanagement.services.equipement;

import tn.pi.trainermanagement.tools.dtos.EquipementDto;

import java.util.List;

public interface IEquipementService {


    public List<EquipementDto> getAllEquipements();
    public EquipementDto getEquipementById(long id);
    public EquipementDto addEquipement(EquipementDto equipement);
    public EquipementDto updateEquipement(EquipementDto equipement);
    public List<EquipementDto> getAllEquipementByEquipementTypeTypeName(String equipementTypename);
    public void deleteEquipement(long id);
}

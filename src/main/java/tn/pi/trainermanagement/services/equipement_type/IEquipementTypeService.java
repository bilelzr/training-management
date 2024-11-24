package tn.pi.trainermanagement.services.equipement_type;

import tn.pi.trainermanagement.tools.dtos.EquipementTypeDto;

import java.util.List;

public interface IEquipementTypeService {

    List<EquipementTypeDto> getAllEquipementType();

    EquipementTypeDto createEquipementType(EquipementTypeDto equipementTypeDto);

    EquipementTypeDto updateEquipementType(EquipementTypeDto equipementTypeDto);

    void deleteEquipementType(long equipementTypeId);
}

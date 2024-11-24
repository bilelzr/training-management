package tn.pi.trainermanagement.services.equipement_type;

import org.springframework.stereotype.Service;
import tn.pi.trainermanagement.entities.EquipementType;
import tn.pi.trainermanagement.repositories.EquipementTypeRepository;
import tn.pi.trainermanagement.tools.Tools;
import tn.pi.trainermanagement.tools.dtos.EquipementTypeDto;

import java.util.List;


@Service
public class EquipementTypeServiceImpl implements IEquipementTypeService {


    private final EquipementTypeRepository equipementTypeRepository;

    public EquipementTypeServiceImpl(EquipementTypeRepository equipementTypeRepository) {
        this.equipementTypeRepository = equipementTypeRepository;
    }


    @Override
    public List<EquipementTypeDto> getAllEquipementType() {
        List<EquipementType> list = equipementTypeRepository.findAll();
        return Tools.mapListEquipementTypeToDto(list);
    }

    @Override
    public EquipementTypeDto createEquipementType(EquipementTypeDto equipementTypeDto) {
        return null;
    }

    @Override
    public EquipementTypeDto updateEquipementType(EquipementTypeDto equipementTypeDto) {
        return null;
    }

    @Override
    public void deleteEquipementType(long equipementTypeId) {

    }
}

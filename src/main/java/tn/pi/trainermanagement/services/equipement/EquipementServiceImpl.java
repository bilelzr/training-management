package tn.pi.trainermanagement.services.equipement;

import org.springframework.stereotype.Service;
import tn.pi.trainermanagement.entities.Equipement;
import tn.pi.trainermanagement.repositories.EquipementRepository;
import tn.pi.trainermanagement.tools.Tools;
import tn.pi.trainermanagement.tools.dtos.EquipementDto;

import java.util.List;


@Service
public class EquipementServiceImpl implements IEquipementService {

    private final EquipementRepository equipementRepository;

    public EquipementServiceImpl(EquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    @Override
    public List<EquipementDto> getAllEquipements() {
        List<Equipement> equipements = equipementRepository.findAll();
        return Tools.mapListEquipementToDto(equipements);
    }

    @Override
    public EquipementDto getEquipementById(long id) {
        return null;
    }

    @Override
    public EquipementDto addEquipement(EquipementDto equipement) {
        return null;
    }

    @Override
    public EquipementDto updateEquipement(EquipementDto equipement) {
        return null;
    }

    @Override
    public List<EquipementDto> getAllEquipementByEquipementTypeTypeName(String equipementTypename) {
        return List.of();
    }

    @Override
    public void deleteEquipement(long id) {

    }
}

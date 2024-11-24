package tn.pi.trainermanagement.web;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.pi.trainermanagement.services.equipement.IEquipementService;
import tn.pi.trainermanagement.tools.dtos.EquipementDto;

import java.util.List;

@RestController
@RequestMapping("/equipement")
public class EquipementController {

    private final IEquipementService equipementService;

    public EquipementController(IEquipementService equipementService) {
        this.equipementService = equipementService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<EquipementDto>> getAllEquipement() {
        return ResponseEntity.ok(equipementService.getAllEquipements());
    }
}

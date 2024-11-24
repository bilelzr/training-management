package tn.pi.trainermanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.trainermanagement.entities.EquipementType;

@Repository
public interface  EquipementTypeRepository extends JpaRepository<EquipementType, Long> {
}

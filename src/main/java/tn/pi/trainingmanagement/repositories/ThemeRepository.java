package tn.pi.trainingmanagement.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.trainingmanagement.entities.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
    Theme findByThemeName(String themeName);


}

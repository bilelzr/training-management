package tn.pi.trainingmanagement.services.theme;

import org.springframework.stereotype.Service;
import tn.pi.trainingmanagement.entities.Theme;
import tn.pi.trainingmanagement.repositories.ThemeRepository;
import tn.pi.trainingmanagement.tools.Tools;
import tn.pi.trainingmanagement.tools.dtos.ThemeDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ThemeServiceImpl implements IThemeService {


    private final ThemeRepository themeRepository;


    public ThemeServiceImpl(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    @Override
    public List<ThemeDto> getAllTheme() {
        List<Theme> themes = themeRepository.findAll();
        return Tools.mapThemeListToDtoList(themes);
    }

    @Override
    public ThemeDto getThemeByName(String themeName) {
        Theme theme = themeRepository.findByThemeName(themeName);
        return Tools.mapThemeToDto(theme);
    }

    @Override
    public ThemeDto getThemeById(long themeId) {
        Optional<Theme> theme = themeRepository.findById(themeId);
        return theme.map(Tools::mapThemeToDto).orElse(null);
    }

    @Override
    public ThemeDto addTheme(ThemeDto themeDto) {
        Theme theme = new Theme();
        theme.setThemeName(themeDto.getThemeName());
        theme.setThemeDescription(themeDto.getThemeDescription());
        theme.setCreatedAt(LocalDateTime.now());
        return Tools.mapThemeToDto(themeRepository.save(theme));
    }

    @Override
    public ThemeDto updateTheme(ThemeDto themeDto) {
        Optional<Theme> optionalTheme = themeRepository.findById(themeDto.getThemeId());
        if (optionalTheme.isPresent()) {
            Theme theme = optionalTheme.get();
            theme.setThemeName(themeDto.getThemeName());
            theme.setThemeDescription(themeDto.getThemeDescription());
            theme.setCreatedAt(LocalDateTime.now());
            return Tools.mapThemeToDto(themeRepository.save(theme));
        }
        return null;
    }

    @Override
    public void deleteTheme(long themeId) {
        Optional<Theme> optionalTheme = themeRepository.findById(themeId);
        if (optionalTheme.isPresent()) {
            Theme theme = optionalTheme.get();
            themeRepository.delete(theme);
        }
    }
}

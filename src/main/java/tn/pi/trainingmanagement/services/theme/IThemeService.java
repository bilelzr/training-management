package tn.pi.trainingmanagement.services.theme;

import tn.pi.trainingmanagement.tools.dtos.ThemeDto;

import java.util.List;

public interface IThemeService {


    List<ThemeDto> getAllTheme();

    ThemeDto getThemeByName(String themeName);

    ThemeDto getThemeById(long themeId);

    ThemeDto addTheme(ThemeDto themeDto);

    ThemeDto updateTheme(ThemeDto themeDto);

    void deleteTheme(long themeId);


}

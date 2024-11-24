package tn.pi.trainingmanagement.web;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.trainingmanagement.services.theme.IThemeService;
import tn.pi.trainingmanagement.tools.dtos.ThemeDto;

import java.util.List;

@RestController
@RequestMapping("/theme")
public class ThemeController {

    private final IThemeService themeService;

    public ThemeController(IThemeService themeService) {
        this.themeService = themeService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<ThemeDto>> getAllThemes() {
        return ResponseEntity.ok(themeService.getAllTheme());
    }

    @GetMapping("/getByName/{themeName}")
    public ResponseEntity<ThemeDto> getThemeByName(@PathVariable String themeName) {
        return ResponseEntity.ok(themeService.getThemeByName(themeName));
    }

    @GetMapping("/getById/{themeId}")
    public ResponseEntity<ThemeDto> getThemeById(@PathVariable long themeId) {
        return ResponseEntity.ok(themeService.getThemeById(themeId));
    }

    @PostMapping("/new")
    public ResponseEntity<ThemeDto> addTheme(@RequestBody ThemeDto themeDto) {
        return ResponseEntity.ok(themeService.addTheme(themeDto));
    }

    @PutMapping
    public ResponseEntity<ThemeDto> updateTheme(@RequestBody ThemeDto themeDto) {
        return ResponseEntity.ok(themeService.updateTheme(themeDto));
    }

    public ResponseEntity<String> deleteTheme(long themeId) {
        themeService.deleteTheme(themeId);
        return ResponseEntity.ok("Theme deleted successfully");
    }
}

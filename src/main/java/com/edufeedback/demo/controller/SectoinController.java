package com.edufeedback.demo.controller;

import com.edufeedback.demo.model.Section;
import com.edufeedback.demo.service.SectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sections")
@CrossOrigin(origins = "http://localhost:5173")
public class SectoinController {

    private final SectionService sectionService;

    public SectoinController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping
    public List<Section> getAll() {
        return sectionService.findAll();
    }

    @PostMapping
    public ResponseEntity<Section> create(
            @RequestParam Long subjectId,
            @RequestBody Section section) {
        return ResponseEntity.ok(sectionService.create(subjectId, section));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Section> update(
            @PathVariable Long id,
            @RequestBody Section section) {
        return ResponseEntity.ok(sectionService.update(id, section));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sectionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
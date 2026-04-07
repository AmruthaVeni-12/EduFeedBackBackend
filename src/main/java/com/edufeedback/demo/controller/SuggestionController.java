package com.edufeedback.demo.controller;

import com.edufeedback.demo.model.Suggestion;
import com.edufeedback.demo.service.SuggestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
@CrossOrigin(origins = "*")
public class SuggestionController {

    private final SuggestionService suggestionService;

    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @GetMapping
    public List<Suggestion> getAll() {
        return suggestionService.findAll();
    }

    @PostMapping
    public ResponseEntity<Suggestion> create(@RequestBody Suggestion suggestion) {
        Long sectionId = suggestion.getSection() != null ? suggestion.getSection().getId() : null;
        if (sectionId == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(suggestionService.create(sectionId, suggestion));
    }
}
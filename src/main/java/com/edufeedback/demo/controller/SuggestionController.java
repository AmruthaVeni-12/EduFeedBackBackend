package com.edufeedback.demo.controller;

import com.edufeedback.demo.model.Suggestion;
import com.edufeedback.demo.service.SuggestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
@CrossOrigin(origins = "http://localhost:5173")
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
    public ResponseEntity<Suggestion> create(
            @RequestParam Long sectionId,
            @RequestBody Suggestion suggestion) {
        return ResponseEntity.ok(suggestionService.create(sectionId, suggestion));
    }
}
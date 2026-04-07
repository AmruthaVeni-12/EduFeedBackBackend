package com.edufeedback.demo.service;

import com.edufeedback.demo.model.Section;
import com.edufeedback.demo.model.Suggestion;
import com.edufeedback.demo.repository.SectionRepository;
import com.edufeedback.demo.repository.SuggestionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SuggestionService {

    private final SuggestionRepository suggestionRepository;
    private final SectionRepository sectionRepository;

    public SuggestionService(SuggestionRepository suggestionRepository, SectionRepository sectionRepository) {
        this.suggestionRepository = suggestionRepository;
        this.sectionRepository = sectionRepository;
    }

    public List<Suggestion> findAll() {
        return suggestionRepository.findAll();
    }

    public Suggestion create(Long sectionId, Suggestion suggestion) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new IllegalArgumentException("Section not found: " + sectionId));
        suggestion.setSection(section);
        return suggestionRepository.save(suggestion);
    }
}
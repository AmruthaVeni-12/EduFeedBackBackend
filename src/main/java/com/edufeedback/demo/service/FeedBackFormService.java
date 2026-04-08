package com.edufeedback.demo.service;

import com.edufeedback.demo.model.FeedBackForm;
import com.edufeedback.demo.model.Section;
import com.edufeedback.demo.repository.FeedBackFormRepository;
import com.edufeedback.demo.repository.SectionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedBackFormService {

    private final FeedBackFormRepository formRepository;
    private final SectionRepository sectionRepository;

    public FeedBackFormService(FeedBackFormRepository formRepository, SectionRepository sectionRepository) {
        this.formRepository = formRepository;
        this.sectionRepository = sectionRepository;
    }

    public List<FeedBackForm> findAll() {
        return formRepository.findAll();
    }

    public FeedBackForm create(Long sectionId, FeedBackForm form) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new IllegalArgumentException("Section not found: " + sectionId));
        form.setSection(section);
        return formRepository.save(form);
    }

    public FeedBackForm update(Long id, FeedBackForm form) {
        FeedBackForm existing = formRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Form not found: " + id));
        existing.setTitle(form.getTitle());
        existing.setDescription(form.getDescription());
        existing.setStartDate(form.getStartDate());
        existing.setEndDate(form.getEndDate());
        existing.setTimeLimitMinutes(form.getTimeLimitMinutes());
        existing.setQuestionsJson(form.getQuestionsJson());
        return formRepository.save(existing);
    }

    public void delete(Long id) {
        formRepository.deleteById(id);
    }
}
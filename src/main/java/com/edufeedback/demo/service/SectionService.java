package com.edufeedback.demo.service;

import com.edufeedback.demo.model.Section;
import com.edufeedback.demo.model.Subject;
import com.edufeedback.demo.repository.SectionRepository;
import com.edufeedback.demo.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;
    private final SubjectRepository subjectRepository;

    public SectionService(SectionRepository sectionRepository, SubjectRepository subjectRepository) {
        this.sectionRepository = sectionRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    public Section create(Long subjectId, Section section) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found: " + subjectId));
        section.setSubject(subject);
        return sectionRepository.save(section);
    }

    public Section update(Long id, Section section) {
        Section existing = sectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Section not found: " + id));
        existing.setSectionName(section.getSectionName());
        existing.setDescription(section.getDescription());
        return sectionRepository.save(existing);
    }

    public void delete(Long id) {
        sectionRepository.deleteById(id);
    }
}
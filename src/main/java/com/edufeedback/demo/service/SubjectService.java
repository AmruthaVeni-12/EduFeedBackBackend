package com.edufeedback.demo.service;

import com.edufeedback.demo.model.Subject;
import com.edufeedback.demo.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository repository;

    public SubjectService(SubjectRepository repository) {
        this.repository = repository;
    }

    public List<Subject> findAll() {
        return repository.findAll();
    }

    public Subject findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found: " + id));
    }

    public Subject create(Subject subject) {
        return repository.save(subject);
    }

    public Subject update(Long id, Subject subject) {
        Subject existing = findById(id);
        existing.setName(subject.getName());
        existing.setCode(subject.getCode());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
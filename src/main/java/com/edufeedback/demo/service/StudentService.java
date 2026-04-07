package com.edufeedback.demo.service;

import com.edufeedback.demo.model.Section;
import com.edufeedback.demo.model.Student;
import com.edufeedback.demo.model.Subject;
import com.edufeedback.demo.repository.SectionRepository;
import com.edufeedback.demo.repository.StudentRepository;
import com.edufeedback.demo.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final SectionRepository sectionRepository;

    public StudentService(StudentRepository studentRepository, SubjectRepository subjectRepository, SectionRepository sectionRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.sectionRepository = sectionRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student enroll(Long subjectId, Long sectionId, Student student) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found: " + subjectId));
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new IllegalArgumentException("Section not found: " + sectionId));
        student.setSubject(subject);
        student.setSection(section);
        return studentRepository.save(student);
    }
}
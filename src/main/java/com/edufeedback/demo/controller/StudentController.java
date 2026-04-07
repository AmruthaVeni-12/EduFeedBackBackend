package com.edufeedback.demo.controller;

import com.edufeedback.demo.model.Student;
import com.edufeedback.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @PostMapping("/enroll")
    public ResponseEntity<Student> enroll(
            @RequestParam Long subjectId,
            @RequestParam Long sectionId,
            @RequestBody Student student) {
        return ResponseEntity.ok(studentService.enroll(subjectId, sectionId, student));
    }
}
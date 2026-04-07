package com.edufeedback.demo.controller;

import com.edufeedback.demo.model.FeedBackSubmission;
import com.edufeedback.demo.service.FeedBackSubmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/submissions")
@CrossOrigin(origins = "*")
public class FeedBackSubmissionController {

    private final FeedBackSubmissionService submissionService;

    public FeedBackSubmissionController(FeedBackSubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping
    public List<FeedBackSubmission> getAll() {
        return submissionService.findAll();
    }

    @PostMapping
    public ResponseEntity<FeedBackSubmission> create(
            @RequestParam Long formId,
            @RequestBody FeedBackSubmission submission) {
        return ResponseEntity.ok(submissionService.create(formId, submission));
    }
}
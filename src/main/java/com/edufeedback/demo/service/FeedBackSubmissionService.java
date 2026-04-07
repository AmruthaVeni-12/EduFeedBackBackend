package com.edufeedback.demo.service;

import com.edufeedback.demo.model.FeedBackForm;
import com.edufeedback.demo.model.FeedBackSubmission;
import com.edufeedback.demo.repository.FeedBackFormRepository;
import com.edufeedback.demo.repository.FeedBackSubmissionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedBackSubmissionService {

    private final FeedBackSubmissionRepository submissionRepository;
    private final FeedBackFormRepository formRepository;

    public FeedBackSubmissionService(FeedBackSubmissionRepository submissionRepository, FeedBackFormRepository formRepository) {
        this.submissionRepository = submissionRepository;
        this.formRepository = formRepository;
    }

    public List<FeedBackSubmission> findAll() {
        return submissionRepository.findAll();
    }

    public FeedBackSubmission create(Long formId, FeedBackSubmission submission) {
        FeedBackForm form = formRepository.findById(formId)
                .orElseThrow(() -> new IllegalArgumentException("Form not found: " + formId));
        submission.setForm(form);
        submission.setSection(form.getSection());
        return submissionRepository.save(submission);
    }
}
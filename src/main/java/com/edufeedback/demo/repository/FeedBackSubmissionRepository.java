package com.edufeedback.demo.repository;

import com.edufeedback.demo.model.FeedBackSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackSubmissionRepository extends JpaRepository<FeedBackSubmission, Long> {}
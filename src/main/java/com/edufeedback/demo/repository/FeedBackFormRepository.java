package com.edufeedback.demo.repository;

import com.edufeedback.demo.model.FeedBackForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackFormRepository extends JpaRepository<FeedBackForm, Long> {}
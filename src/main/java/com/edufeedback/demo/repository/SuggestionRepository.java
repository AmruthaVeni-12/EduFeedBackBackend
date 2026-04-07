package com.edufeedback.demo.repository;

import com.edufeedback.demo.model.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {}
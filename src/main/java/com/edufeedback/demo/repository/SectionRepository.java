package com.edufeedback.demo.repository;

import com.edufeedback.demo.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {}
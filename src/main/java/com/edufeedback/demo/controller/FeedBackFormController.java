package com.edufeedback.demo.controller;

import com.edufeedback.demo.model.FeedBackForm;
import com.edufeedback.demo.service.FeedBackFormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forms")
@CrossOrigin(origins = "*")
public class FeedBackFormController {

    private final FeedBackFormService formService;

    public FeedBackFormController(FeedBackFormService formService) {
        this.formService = formService;
    }

    @GetMapping
    public List<FeedBackForm> getAll() {
        return formService.findAll();
    }

    @PostMapping
    public ResponseEntity<FeedBackForm> create(
            @RequestParam(required = false) Long sectionId,
            @RequestBody FeedBackForm form) {
        Long resolvedSectionId = sectionId;
        if (resolvedSectionId == null && form.getSection() != null) {
            resolvedSectionId = form.getSection().getId();
        }
        if (resolvedSectionId == null) {
            throw new IllegalArgumentException("sectionId is required to create a form");
        }
        return ResponseEntity.ok(formService.create(resolvedSectionId, form));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedBackForm> update(
            @PathVariable Long id,
            @RequestBody FeedBackForm form) {
        return ResponseEntity.ok(formService.update(id, form));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        formService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
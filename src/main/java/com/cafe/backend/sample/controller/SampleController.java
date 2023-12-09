package com.cafe.backend.sample.controller;

import com.cafe.backend.sample.controller.form.SampleAddForm;
import com.cafe.backend.sample.controller.form.SampleModifyForm;
import com.cafe.backend.sample.service.SampleService;
import com.cafe.backend.sample.service.dto.SampleReadResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @PostMapping("/samples")
    public void add(@Valid @RequestBody SampleAddForm sampleAddForm) {
        sampleService.add(sampleAddForm.toDto());
    }

    @GetMapping("/samples/{id}")
    public SampleReadResponse get(@PathVariable Long id) {
        return sampleService.get(id);
    }

    @PutMapping("/samples/{id}")
    public void modify(@PathVariable Long id, @Valid @RequestBody SampleModifyForm sampleModifyForm) {
        sampleService.modify(id, sampleModifyForm.toDto());
    }

    @DeleteMapping("/samples/{id}")
    public void remove(@PathVariable Long id) {
        sampleService.remove(id);
    }
}

package com.project.insert.controller;

import com.project.insert.controller.dto.SaveGenerationDto;
import com.project.insert.repository.GenerationRepository;
import com.project.insert.service.GenerationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class GenerationController {
    private final GenerationService generationService;

    @PostMapping("/api/member/generation")
    public String createGeneration(@RequestBody SaveGenerationDto requestDto){
        return generationService.save(requestDto);
    }
}

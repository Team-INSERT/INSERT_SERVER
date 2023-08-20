package com.project.insert.controller;

import com.project.insert.controller.dto.SaveGenerationDto;
import com.project.insert.service.GenerationService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class GenerationController {
    private final GenerationService generationService;
    @PostMapping("/api/member/generation")
    public String createGeneration(@RequestBody SaveGenerationDto requestDto){
        return generationService.save(requestDto);
    }

    @GetMapping("/api/member/{team}")
    @ResponseBody
    public JSONArray getMemberFront(@PathVariable String team) throws Exception {
        return generationService.getMember(team);
    }
}

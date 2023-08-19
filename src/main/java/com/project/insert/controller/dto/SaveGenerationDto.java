package com.project.insert.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SaveGenerationDto {
    private String accessCode;
    private String githubId;
    private String generation;
}

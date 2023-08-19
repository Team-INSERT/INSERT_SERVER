package com.project.insert.domain;

import com.project.insert.controller.dto.SaveGenerationDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Generation {
    @Id
    @Column
    private String id;

    @Column(nullable = false)
    private String generation;

    public Generation(SaveGenerationDto generationDto) {
        this.id = generationDto.getGithubId();
        this.generation = generationDto.getGeneration();
    }
}

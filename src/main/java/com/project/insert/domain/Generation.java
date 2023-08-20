package com.project.insert.domain;

import com.project.insert.controller.dto.SaveGenerationDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Generation {
    @Id
    @Column
    private String id;

    @Column
    private Integer generation;

    public Generation(SaveGenerationDto generationDto) {
        this.id = generationDto.getGithubId();
        this.generation = generationDto.getGeneration();
    }
}

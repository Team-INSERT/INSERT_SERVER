package com.project.insert.service;


import com.project.insert.controller.dto.SaveGenerationDto;
import com.project.insert.domain.Generation;
import com.project.insert.exception.InvalidAccessCodeException;
import com.project.insert.repository.GenerationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@AllArgsConstructor
@Service
public class GenerationService {

    @Value("${spring.accessCode}")
    private String accessCode;

    private final GenerationRepository generationRepository;

    public String save(SaveGenerationDto requestDto){

        if(!requestDto.getAccessCode().equals(accessCode)){
            throw InvalidAccessCodeException.EXCEPTION;
        }
        return generationRepository.save(new Generation(requestDto)).getId();
    }
}

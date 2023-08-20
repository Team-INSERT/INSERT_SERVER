package com.project.insert.service;


import com.project.insert.controller.dto.SaveGenerationDto;
import com.project.insert.domain.Generation;
import com.project.insert.exception.InvalidAccessCodeException;
import com.project.insert.repository.GenerationRepository;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class GenerationService {
    @Value("${spring.accessCode}")
    private String accessCode;
    @Value("${spring.github.token}")
    private String token;
    private String org = "Team-INSERT";
    private final GenerationRepository generationRepository;

    public String save(SaveGenerationDto requestDto){
        if(!requestDto.getAccessCode().equals(accessCode)){
            throw InvalidAccessCodeException.EXCEPTION;
        }
        return generationRepository.save(new Generation(requestDto)).getId();
    }

    public JSONArray getMember(String team) throws Exception{
        JSONParser parser = new JSONParser();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(String.format("https://api.github.com/orgs/%s/teams/%s/members", org,team))
                .addHeader("Accept","application/vnd.github+json")
                .addHeader("Authorization", String.format("Bearer %s",token))
                .build();

        Response response = client.newCall(request).execute();
        String body = response.body().string();
        JSONArray jsonArray = (JSONArray) parser.parse(body);

        for(int i = 0;i < jsonArray.size();i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String githubId = jsonObject.get("login").toString();
            Optional<Generation> generation = generationRepository.findById(githubId);

            if(generation.isPresent()){
                jsonObject.put("generation",generation.get().getGeneration());
            } else {
                jsonObject.put("generation",null);
            }
        }
        return jsonArray;
    }
}

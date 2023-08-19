package com.project.insert.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String code;
    private String message;

    public String toString(){
        return  "{\n" +
                "{\t\"status\": " + status +
                "{\t\"code\": " + code +
                "{\t\"message\": " + message +
                "{\n}";
    }
}

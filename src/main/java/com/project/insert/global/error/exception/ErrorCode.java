package com.project.insert.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    INVALID_ACCESS_CODE(403, "GENERATION_403", "Access with Invalid Code"),
    INTERNAL_SERVER_ERROR(500, "SERVER-500", "Internal Server Error");

    private final int status;
    private final String code;
    private final String message;
}

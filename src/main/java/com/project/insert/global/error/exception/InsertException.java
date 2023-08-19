package com.project.insert.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class InsertException extends RuntimeException {
    private final ErrorCode errorCode;
}

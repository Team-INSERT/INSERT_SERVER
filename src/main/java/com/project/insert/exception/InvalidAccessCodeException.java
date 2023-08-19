package com.project.insert.exception;

import com.project.insert.global.error.exception.ErrorCode;
import com.project.insert.global.error.exception.InsertException;

public class InvalidAccessCodeException extends InsertException {
    public static final InvalidAccessCodeException EXCEPTION = new InvalidAccessCodeException(ErrorCode.INVALID_ACCESS_CODE);

    public InvalidAccessCodeException(ErrorCode errorCode){
        super(errorCode);
    }
}

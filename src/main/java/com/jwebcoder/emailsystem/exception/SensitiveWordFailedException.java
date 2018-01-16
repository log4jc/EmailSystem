package com.jwebcoder.emailsystem.exception;

import com.jwebcoder.emailsystem.enums.EmailSystemErrorStatusCode;

public class SensitiveWordFailedException extends EmailSystemException {


    public SensitiveWordFailedException() {
        super(EmailSystemErrorStatusCode.SENSITIVE_WORD_FAILED);
    }
}

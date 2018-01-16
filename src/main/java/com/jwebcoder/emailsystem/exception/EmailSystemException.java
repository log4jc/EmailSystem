package com.jwebcoder.emailsystem.exception;

import com.jwebcoder.emailsystem.enums.EmailSystemErrorStatusCode;

public abstract class EmailSystemException extends RuntimeException {

    private int code;
    private String brieInfo;
    private String detailInfo;

    public EmailSystemException(EmailSystemErrorStatusCode emailSystemErrorStatusCode) {
        super(emailSystemErrorStatusCode.getDetailInfo());
        this.code = emailSystemErrorStatusCode.getCode();
        this.brieInfo = emailSystemErrorStatusCode.getBrieInfo();
        this.detailInfo = emailSystemErrorStatusCode.getDetailInfo();
    }

    public int getCode() {
        return code;
    }

    public String getBrieInfo() {
        return brieInfo;
    }

    public String getDetailInfo() {
        return detailInfo;
    }
}

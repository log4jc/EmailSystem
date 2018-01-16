package com.jwebcoder.emailsystem.dto;

public class EmailSendStateResponse {

    private String flag;

    public EmailSendStateResponse() {}

    public EmailSendStateResponse(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }
}

package com.jwebcoder.emailsystem.dto;

public class EmailSendType<T> {

    /**
     * emailType为SimplyEmail或者是HTMLEmail
     */
    private String emailType;
    private Boolean isIncludAttachment;
    private T data;

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public Boolean getIncludAttachment() {
        return isIncludAttachment;
    }

    public void setIncludAttachment(Boolean includAttachment) {
        isIncludAttachment = includAttachment;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

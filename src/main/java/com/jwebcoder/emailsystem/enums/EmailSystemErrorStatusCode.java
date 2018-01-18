package com.jwebcoder.emailsystem.enums;

public enum EmailSystemErrorStatusCode {
    SUCCESSFUL(100,"成功","访问成功"),
    UNKNOWN(-1,"未知错误","未知的错误"),
    SEND_FAILED(101, "服务器内部错误","因未知原因导致服务器内部错误"),
    SENSITIVE_WORD_FAILED(102, "敏感词错误","发送的邮件内容包含了未被许可的信息，或被系统识别为垃圾邮件。请检查是否有用户发送病毒或者垃圾邮件"),
    ;

    private int code;
    private String brieInfo;
    private String detailInfo;

    EmailSystemErrorStatusCode(int code, String brieInfo, String detailInfo) {
        this.code = code;
        this.brieInfo = brieInfo;
        this.detailInfo = detailInfo;
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

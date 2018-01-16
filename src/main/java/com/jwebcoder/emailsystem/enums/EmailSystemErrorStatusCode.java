package com.jwebcoder.emailsystem.enums;

public enum EmailSystemErrorStatusCode {
    SUCCESSFUL(100,"成功","访问成功"),
    UNKNOWN(-1,"未知错误","未知的错误"),
    SEND_FAILED(101, "","服务器内部错误"),
    SENSITIVE_WORD_FAILED(102, "敏感词错误","554 DT:SPM 163 smtp9,DcCowACnFNwSGl5aoo11BQ--.49157S3 1516116559,please see http://mail.163.com/help/help_spam_16.htm?ip=43.243.148.215&hostid=smtp9&time=1516116559"),
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

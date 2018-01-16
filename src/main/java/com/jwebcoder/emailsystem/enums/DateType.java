package com.jwebcoder.emailsystem.enums;

/**
 * Created by Jason on 18/11/2017.
 */
public enum DateType {

    MDHMSS("MMddHHmmssSSS"),
    YMDHMS("yyyyMMddHHmmss"),
    YMDHMS_("yyyy-MM-dd HH:mm:ss"),
    YMD("yyyyMMdd"),
    YMD_("yyyy-MM-dd"),
    HMS("HHmmss"),
    ;

    private String type;

    DateType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

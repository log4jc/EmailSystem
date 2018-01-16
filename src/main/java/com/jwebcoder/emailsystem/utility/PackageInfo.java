package com.jwebcoder.emailsystem.utility;

import com.jwebcoder.emailsystem.dto.Message;
import com.jwebcoder.emailsystem.enums.EmailSystemErrorStatusCode;
import com.jwebcoder.emailsystem.exception.EmailSystemException;

public class PackageInfo {

    public static Message packageSuccess(Object object) {

        Message message = new Message();
        message.setId(EmailSystemErrorStatusCode.SUCCESSFUL.getCode());
        message.setMessage(EmailSystemErrorStatusCode.SUCCESSFUL.getDetailInfo());
        message.setData(object);

        return message;
    }

    public static Message packageFailed(EmailSystemException emailSystemException) {

        Message message = new Message();
        message.setId(emailSystemException.getCode());
        message.setMessage(emailSystemException.getDetailInfo());

        return message;
    }

}

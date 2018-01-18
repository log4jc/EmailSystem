package com.jwebcoder.emailsystem.aop;

import com.jwebcoder.emailsystem.dto.Message;
import com.jwebcoder.emailsystem.enums.EmailSystemErrorStatusCode;
import com.jwebcoder.emailsystem.exception.EmailSystemException;
import com.jwebcoder.emailsystem.exception.SensitiveWordFailedException;
import com.jwebcoder.emailsystem.utility.PackageInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CatchException {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Message catchException(Exception exception) {


        if (exception instanceof SensitiveWordFailedException) {

            return PackageInfo.packageFailed((SensitiveWordFailedException) exception);

        } else {

            return PackageInfo.packageFailed(new EmailSystemException(EmailSystemErrorStatusCode.UNKNOWN) {});

        }

    }

}

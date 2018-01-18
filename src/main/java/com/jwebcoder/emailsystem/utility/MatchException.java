package com.jwebcoder.emailsystem.utility;

import com.jwebcoder.emailsystem.exception.SensitiveWordFailedException;

public class MatchException {

    public static void matchException(String exceptionDescription) {

        if (exceptionDescription.contains("SMTPSendFailedException: 554 DT:SPM")) {
            throw new SensitiveWordFailedException();
        }

    }

}

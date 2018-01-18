package com.jwebcoder.emailsystem.utility;

import com.jwebcoder.emailsystem.entity.EmailSendState;
import com.jwebcoder.emailsystem.entity.HtmlEmail;
import com.jwebcoder.emailsystem.entity.SimpleEmail;

public class LogTransfer {

    public static EmailSendState transfer2Log(SimpleEmail simpleEmail, boolean status, String descr) {
        EmailSendState emailSendState = new EmailSendState();

        emailSendState.setEmailId(simpleEmail.getId() == null ? "directly" : simpleEmail.getId());
        emailSendState.setCreateDatetime(DateUtility.getCurrentDate());
        emailSendState.setLastUpdateDatetime(DateUtility.getCurrentDate());
        emailSendState.setVersion(0);
        emailSendState.setStatus(status ? "Successful" : "Failed");
        emailSendState.setType("SimpleEmail");
        emailSendState.setErrorDescr(descr);

        return emailSendState;
    }

    public static EmailSendState transfer2Log(HtmlEmail htmlEmail, boolean status, String descr) {
        EmailSendState emailSendState = new EmailSendState();

        emailSendState.setEmailId(htmlEmail.getId() == null ? "directly" : htmlEmail.getId());
        emailSendState.setCreateDatetime(DateUtility.getCurrentDate());
        emailSendState.setLastUpdateDatetime(DateUtility.getCurrentDate());
        emailSendState.setEmailId(htmlEmail.getId());
        emailSendState.setVersion(0);
        emailSendState.setStatus(status ? "Successful" : "Failed");
        emailSendState.setType("HtmlEmail");
        emailSendState.setErrorDescr(descr);

        return emailSendState;
    }

}

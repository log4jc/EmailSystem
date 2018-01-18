package com.jwebcoder.emailsystem.service;

import com.jwebcoder.emailsystem.entity.EmailSendState;
import com.jwebcoder.emailsystem.entity.HtmlEmail;
import com.jwebcoder.emailsystem.entity.SimpleEmail;

public interface SendService {

    EmailSendState sendSimpleEmail(SimpleEmail simpleEmail);
    EmailSendState sendHtmlEmail(HtmlEmail htmlEmail);
    EmailSendState sendHtmlEmail(HtmlEmail htmlEmail, String attachmentId);

    EmailSendState sendSimpleEmail(String id);
    EmailSendState sendHtmlEmail(String id);
    EmailSendState sendHtmlEmail(String id, String attachmentId);

}

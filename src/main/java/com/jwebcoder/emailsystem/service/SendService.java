package com.jwebcoder.emailsystem.service;

import com.jwebcoder.emailsystem.dto.Message;
import com.jwebcoder.emailsystem.entity.HtmlEmail;
import com.jwebcoder.emailsystem.entity.SimpleEmail;

public interface SendService {

    boolean sendSimpleEmail(SimpleEmail simpleEmail);
    boolean sendHtmlEmail(HtmlEmail htmlEmail);
    boolean sendHtmlEmail(HtmlEmail htmlEmail, String attachmentId);

    Message sendSimpleEmail(String id);
    Message sendHtmlEmail(String id);
    Message sendHtmlEmail(String id, String attachmentId);

}

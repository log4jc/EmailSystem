package com.jwebcoder.emailsystem.service;

import com.jwebcoder.emailsystem.entity.HtmlEmail;
import com.jwebcoder.emailsystem.entity.SimpleEmail;

public interface SendService {

    boolean sendSimpleEmail(SimpleEmail simpleEmail);
    boolean sendHtmlEmail(HtmlEmail htmlEmail);

}

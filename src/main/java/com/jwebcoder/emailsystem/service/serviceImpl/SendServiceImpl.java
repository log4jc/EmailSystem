package com.jwebcoder.emailsystem.service.serviceImpl;

import com.jwebcoder.emailsystem.entity.HtmlEmail;
import com.jwebcoder.emailsystem.entity.SimpleEmail;
import com.jwebcoder.emailsystem.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendServiceImpl implements SendService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public boolean sendSimpleEmail(SimpleEmail simpleEmail) {

        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            message.setFrom(simpleEmail.getSendFrom());
            message.setRecipients(Message.RecipientType.TO, simpleEmail.getSendTo()); //自己给自己发送邮件
            if (simpleEmail.getSendCc() != null) {
                message.setRecipients(Message.RecipientType.CC, simpleEmail.getSendCc()); //自己给自己发送邮件
            }
            if (simpleEmail.getSendBcc() != null) {
                message.setRecipients(Message.RecipientType.BCC, simpleEmail.getSendBcc()); //自己给自己发送邮件
            }
            message.setSubject(simpleEmail.getSubject());
            message.setText(simpleEmail.getContent());
            javaMailSender.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean sendHtmlEmail(HtmlEmail htmlEmail) {
        return false;
    }
}

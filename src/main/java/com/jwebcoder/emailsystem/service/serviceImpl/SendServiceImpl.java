package com.jwebcoder.emailsystem.service.serviceImpl;

import com.jwebcoder.emailsystem.dao.AttachmentDao;
import com.jwebcoder.emailsystem.dao.EmailSendStateDao;
import com.jwebcoder.emailsystem.dao.HtmlEmailDao;
import com.jwebcoder.emailsystem.dao.SimpleEmailDao;
import com.jwebcoder.emailsystem.entity.Attachment;
import com.jwebcoder.emailsystem.entity.EmailSendState;
import com.jwebcoder.emailsystem.entity.HtmlEmail;
import com.jwebcoder.emailsystem.entity.SimpleEmail;
import com.jwebcoder.emailsystem.service.SendService;
import com.jwebcoder.emailsystem.utility.LogTransfer;
import com.jwebcoder.emailsystem.utility.MatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendServiceImpl implements SendService {

    private Logger logger = LoggerFactory.getLogger(SendServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private AttachmentDao attachmentDao;

    @Autowired
    private SimpleEmailDao simpleEmailDao;

    @Autowired
    private HtmlEmailDao htmlEmailDao;

    @Autowired
    private EmailSendStateDao emailSendStateDao;

    @Override
    @Transactional
    public EmailSendState sendSimpleEmail(SimpleEmail simpleEmail) {

        SimpleMailMessage message = new SimpleMailMessage();
        EmailSendState emailSendState = null;

        try {
            message.setFrom(simpleEmail.getSendFrom());
            message.setTo(simpleEmail.getSendTo());
            if (simpleEmail.getSendCc() != null) {
                message.setCc(simpleEmail.getSendCc());
            }
            if (simpleEmail.getSendBcc() != null) {
                message.setBcc(simpleEmail.getSendBcc());
            }
            message.setSubject(simpleEmail.getSubject());
            message.setText(simpleEmail.getContent());
            javaMailSender.send(message);

            emailSendState = LogTransfer.transfer2Log(simpleEmail, true, null);

            emailSendStateDao.insert(emailSendState);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            emailSendStateDao.insert(LogTransfer.transfer2Log(simpleEmail, false, e.getMessage()));
            MatchException.matchException(e.getMessage());
        }

        return emailSendState;
    }

    @Override
    @Transactional
    public EmailSendState sendHtmlEmail(HtmlEmail htmlEmail) {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        EmailSendState emailSendState = null;

        try {
            helper = new MimeMessageHelper(message, true, "utf-8");

            helper.setFrom(htmlEmail.getSendFrom());
            helper.setTo(htmlEmail.getSendTo());
            if (htmlEmail.getSendCc() != null) {
                helper.setCc(htmlEmail.getSendCc());
            }
            if (htmlEmail.getSendBcc() != null) {
                helper.setBcc(htmlEmail.getSendBcc());
            }
            helper.setSubject(htmlEmail.getSubject());
            helper.setText(new String(htmlEmail.getContent()), true);
            javaMailSender.send(message);

            emailSendState = LogTransfer.transfer2Log(htmlEmail, true, null);

            emailSendStateDao.insert(emailSendState);

        } catch (MessagingException e) {
            logger.error(e.getMessage(), e);
            emailSendStateDao.insert(LogTransfer.transfer2Log(htmlEmail, false, e.getMessage()));
            MatchException.matchException(e.getMessage());
        }

        return emailSendState;
    }

    @Override
    @Transactional
    public EmailSendState sendHtmlEmail(HtmlEmail htmlEmail, String attachmentId) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        EmailSendState emailSendState = null;

        try {
            helper = new MimeMessageHelper(message, true, "utf-8");

            helper.setFrom(htmlEmail.getSendFrom());
            helper.setTo(htmlEmail.getSendTo());
            if (htmlEmail.getSendCc() != null) {
                helper.setCc(htmlEmail.getSendCc());
            }
            if (htmlEmail.getSendBcc() != null) {
                helper.setBcc(htmlEmail.getSendBcc());
            }
            helper.setSubject(htmlEmail.getSubject());
            helper.setText(new String(htmlEmail.getContent()), true);

            Attachment attachment = attachmentDao.selectByPrimaryKey(attachmentId);

            File attachmentFile = new File(attachment.getUrl());
            helper.addAttachment(attachment.getAttachmentName(), attachmentFile);
            javaMailSender.send(message);

            emailSendState = LogTransfer.transfer2Log(htmlEmail, true, null);
            emailSendStateDao.insert(emailSendState);

        } catch (MessagingException e) {
            logger.error(e.getMessage(), e);
            emailSendStateDao.insert(LogTransfer.transfer2Log(htmlEmail, false, e.getMessage()));

            MatchException.matchException(e.getMessage());
        }

        return emailSendState;
    }

    @Override
    public EmailSendState sendSimpleEmail(String id) {

        return sendSimpleEmail(simpleEmailDao.selectByPrimaryKey(id));

    }

    @Override
    public EmailSendState sendHtmlEmail(String id) {

        return sendHtmlEmail(htmlEmailDao.selectByPrimaryKey(id));

    }

    @Override
    public EmailSendState sendHtmlEmail(String id, String attachmentId) {

        return sendHtmlEmail(htmlEmailDao.selectByPrimaryKey(id), attachmentId);

    }
}

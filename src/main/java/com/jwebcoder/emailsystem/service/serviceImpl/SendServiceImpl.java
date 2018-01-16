package com.jwebcoder.emailsystem.service.serviceImpl;

import com.jwebcoder.emailsystem.dao.AttachmentDao;
import com.jwebcoder.emailsystem.dao.EmailSendStateDao;
import com.jwebcoder.emailsystem.dao.HtmlEmailDao;
import com.jwebcoder.emailsystem.dao.SimpleEmailDao;
import com.jwebcoder.emailsystem.dto.EmailSendStateResponse;
import com.jwebcoder.emailsystem.dto.Message;
import com.jwebcoder.emailsystem.entity.Attachment;
import com.jwebcoder.emailsystem.entity.EmailSendState;
import com.jwebcoder.emailsystem.entity.HtmlEmail;
import com.jwebcoder.emailsystem.entity.SimpleEmail;
import com.jwebcoder.emailsystem.service.SendService;
import com.jwebcoder.emailsystem.utility.DateUtility;
import com.jwebcoder.emailsystem.utility.PackageInfo;
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

    private EmailSendState trasfor2Log(SimpleEmail simpleEmail, boolean status, String descr) {
        EmailSendState emailSendState = new EmailSendState();

        emailSendState.setCreateDatetime(DateUtility.getCurrentDate());
        emailSendState.setLastUpdateDatetime(DateUtility.getCurrentDate());
        emailSendState.setEmailId(simpleEmail.getId());
        emailSendState.setVersion(0);
        emailSendState.setStatus(String.valueOf(status));
        emailSendState.setType("SimpleEmail");

        return emailSendState;
    }

    private EmailSendState trasfor2Log(HtmlEmail htmlEmail, boolean status, String descr) {
        EmailSendState emailSendState = new EmailSendState();

        emailSendState.setCreateDatetime(DateUtility.getCurrentDate());
        emailSendState.setLastUpdateDatetime(DateUtility.getCurrentDate());
        emailSendState.setEmailId(htmlEmail.getId());
        emailSendState.setVersion(0);
        emailSendState.setStatus(String.valueOf(status));
        emailSendState.setType("HtmlEmail");

        return emailSendState;
    }

    @Override
    @Transactional
    public boolean sendSimpleEmail(SimpleEmail simpleEmail) {

        SimpleMailMessage message = new SimpleMailMessage();
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

            emailSendStateDao.insert(trasfor2Log(simpleEmail, true, null));

            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            emailSendStateDao.insert(trasfor2Log(simpleEmail, false, e.getMessage()));
        }

        return false;

    }

    @Override
    @Transactional
    public boolean sendHtmlEmail(HtmlEmail htmlEmail) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
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

            emailSendStateDao.insert(trasfor2Log(htmlEmail, true, null));

            return true;
        } catch (MessagingException e) {
            logger.error(e.getMessage(), e);
            emailSendStateDao.insert(trasfor2Log(htmlEmail, false, e.getMessage()));
        }
        return false;
    }

    @Override
    @Transactional
    public boolean sendHtmlEmail(HtmlEmail htmlEmail, String attachmentId) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
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

            emailSendStateDao.insert(trasfor2Log(htmlEmail, true, null));

            return true;
        } catch (MessagingException e) {
            logger.error(e.getMessage(), e);
            emailSendStateDao.insert(trasfor2Log(htmlEmail, false, e.getMessage()));
        }
        return false;
    }

    @Override
    public Message sendSimpleEmail(String id) {

        SimpleEmail simpleEmail = simpleEmailDao.selectByPrimaryKey(id);

        sendSimpleEmail(simpleEmail);

        return PackageInfo.packageSuccess(new EmailSendStateResponse("successful"));

    }

    @Override
    public Message sendHtmlEmail(String id) {
        HtmlEmail htmlEmail = htmlEmailDao.selectByPrimaryKey(id);

        sendHtmlEmail(htmlEmail);

        return PackageInfo.packageSuccess(new EmailSendStateResponse("successful"));
    }

    @Override
    public Message sendHtmlEmail(String id, String attachmentId) {
        HtmlEmail htmlEmail = htmlEmailDao.selectByPrimaryKey(id);

        sendHtmlEmail(htmlEmail, attachmentId);

        return PackageInfo.packageSuccess(new EmailSendStateResponse("successful"));
    }
}

package com.jwebcoder.emailsystem.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jwebcoder.emailsystem.dto.EmailSendType;
import com.jwebcoder.emailsystem.entity.HtmlEmail;
import com.jwebcoder.emailsystem.entity.SimpleEmail;
import com.jwebcoder.emailsystem.service.ReceiveFromActiveMQService;
import com.jwebcoder.emailsystem.service.SendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiveFromActiveMQServiceImpl implements ReceiveFromActiveMQService {

    private final Logger logger = LoggerFactory.getLogger(ReceiveFromActiveMQServiceImpl.class);

    @Autowired
    private SendService sendService;

    private void handleMessage(String message) {
        logger.info(message);
        EmailSendType emailSendType = JSON.toJavaObject(JSON.parseObject(message), EmailSendType.class);
        JSONObject jsonObject = JSON.parseObject(message);

        switch (emailSendType.getEmailType()) {

            case "SimplyEmail":

                SimpleEmail simpleEmail = JSON.toJavaObject(jsonObject.getJSONObject("data"), SimpleEmail.class);
                sendService.sendSimpleEmail(simpleEmail);

                break;

            case "HTMLEmail":

                HtmlEmail htmlEmail = JSON.toJavaObject(jsonObject.getJSONObject("data"), HtmlEmail.class);
                if (emailSendType.getIncludAttachment())
                    sendService.sendHtmlEmail(htmlEmail, htmlEmail.getAttachment().getId());
                else
                    sendService.sendHtmlEmail(htmlEmail);

                break;

        }
    }

    @Override
    @JmsListener(destination = "email.topicService.text", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopicText(String message) {

        handleMessage(message);

    }

    @Override
    @JmsListener(destination = "email.topicService.object", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopicObject(String message) {

    }

    @Override
    @JmsListener(destination = "email.queueService.text", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueueText(String message) {

        handleMessage(message);

    }

    @Override
    @JmsListener(destination = "email.queueService.object", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueueObject(String message) {

    }
}

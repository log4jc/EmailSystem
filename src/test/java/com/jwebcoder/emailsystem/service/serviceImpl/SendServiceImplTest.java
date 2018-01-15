package com.jwebcoder.emailsystem.service.serviceImpl;

import com.jwebcoder.emailsystem.entity.SimpleEmail;
import com.jwebcoder.emailsystem.service.SendService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SendServiceImplTest {

    @Autowired
    private SendService sendService;

    @Test
    public void sendSimpleEmail() throws Exception {

        SimpleEmail simpleEmail = new SimpleEmail();

        simpleEmail.setSendFrom("jasonliupm@163.com");
        simpleEmail.setSendTo("1034928615@qq.com");
        simpleEmail.setSubject("中午吃饭");
        simpleEmail.setContent("中午是否和我吃饭？");

        Assert.assertTrue(sendService.sendSimpleEmail(simpleEmail));

    }

    @Test
    public void sendHtmlEmail() throws Exception {
    }

}
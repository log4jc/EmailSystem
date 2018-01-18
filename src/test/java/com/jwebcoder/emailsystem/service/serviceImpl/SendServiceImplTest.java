package com.jwebcoder.emailsystem.service.serviceImpl;

import com.jwebcoder.emailsystem.entity.HtmlEmail;
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
    public void sendSimpleEmail1() throws Exception {

//        sendService.sendSimpleEmail("dfasdf");

    }

    @Test
    public void sendHtmlEmail2() throws Exception {
    }

    @Test
    public void sendHtmlEmail3() throws Exception {
    }


    @Test
    public void sendSimpleEmail() throws Exception {

        SimpleEmail simpleEmail = new SimpleEmail();

        simpleEmail.setSendFrom("jasonliupm@163.com");
        simpleEmail.setSendTo("1034928615@qq.com");
        simpleEmail.setSubject("吃饭");
        simpleEmail.setContent("明天一起吃饭吧！");

        sendService.sendSimpleEmail(simpleEmail);
//        Assert.assertTrue(sendService.sendSimpleEmail(simpleEmail));

    }

    @Test
    public void sendHtmlEmail() throws Exception {

        HtmlEmail htmlEmail = new HtmlEmail();

        htmlEmail.setSendFrom("jasonliupm@163.com");
        htmlEmail.setSendTo("1034928615@qq.com");
        htmlEmail.setSubject("中午吃饭");

        StringBuffer sb = new StringBuffer();
        sb.append("<h1>大标题-h1</h1>")
                .append("<p style='color:#F00'>红色字</p>")
                .append("<p style='text-align:right'>右对齐</p>");

        htmlEmail.setContent(sb.toString().getBytes());

//        Assert.assertTrue(sendService.sendHtmlEmail(htmlEmail));

    }

    @Test
    public void sendHtmlEmail1() throws Exception {

        HtmlEmail htmlEmail = new HtmlEmail();

        htmlEmail.setSendFrom("jasonliupm@163.com");
        htmlEmail.setSendTo("1034928615@qq.com");
        htmlEmail.setSubject("中午吃饭");

        StringBuffer sb = new StringBuffer();
        sb.append("<h1>大标题-h1</h1>")
                .append("<p style='color:#F00'>红色字</p>")
                .append("<p style='text-align:right'>右对齐</p>");

        htmlEmail.setContent(sb.toString().getBytes());

//        Assert.assertTrue(sendService.sendHtmlEmail(htmlEmail, "asdfhgbergjb"));

    }

}
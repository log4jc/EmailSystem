package com.jwebcoder.emailsystem.controller;

import com.jwebcoder.emailsystem.dto.Message;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SendEmailControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void sendHtmlEmailByIdWithAttachment() throws Exception {
    }

    @Test
    public void sendHtmlEmailById() throws Exception {
    }

    @Test
    public void sendSimpleEmailById() throws Exception {

       /* Map<String, Object> map = new HashMap<>();
        map.put("id", "dfasdf");
        map.put("version", "1");
        map.put("sendFrom", "jasonliupm@163.com");
        map.put("sendTo", "1034928615@qq.com");
        map.put("sendCc", null);
        map.put("sendBcc", null);
        map.put("subject", "测试");
        map.put("templateRefId", null);
        map.put("owner", null);
        map.put("createDatetime", null);
        map.put("lastUpdateDatetime", null);
        map.put("custom1", null);
        map.put("custom2", null);
        map.put("custom3", null);
        map.put("custom4", null);
        map.put("custom5", null);
        map.put("content", "测试");

        System.out.println(JSONObject.toJSONString(map));*/

        /*MvcResult result = mockMvc.perform(post("/q1?address=合肥").content(JSONObject.toJSONString(map)))
                .andExpect(status().isOk())// 模拟向testRest发送get请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
                .andReturn();// 返回执行请求的结果

        System.out.println(result.getResponse().getContentAsString());*/

    }

    @Test
    public void sendHtmlEmailWithAttachment() throws Exception {
    }

    @Test
    public void sendHtmlEmail() throws Exception {
    }

    @Test
    public void sendSimpleEmail() throws Exception {

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

        RestTemplate restTemplate = restTemplateBuilder.build();

        Message message = new Message();
        message.setId(1);
        message.setMessage("test");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity httpEntity = new HttpEntity(message,httpHeaders);

        ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8081",httpEntity, ResponseEntity.class);


    }

}
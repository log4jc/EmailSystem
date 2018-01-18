package com.jwebcoder.emailsystem.controller;

import com.jwebcoder.emailsystem.dto.Message;
import com.jwebcoder.emailsystem.entity.HtmlEmail;
import com.jwebcoder.emailsystem.entity.SimpleEmail;
import com.jwebcoder.emailsystem.service.SendService;
import com.jwebcoder.emailsystem.utility.PackageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class SendEmailController {

    private final Logger logger = LoggerFactory.getLogger(SendEmailController.class);

    @Autowired
    private SendService sendService;

    @PostMapping("/html/{id}/{attachmentId}/execution")
    public Message sendHtmlEmailByIdWithAttachment(@PathVariable(value = "id") String id, @PathVariable(value = "attachmentId") String attachmentId) {
        return PackageInfo.packageSuccess(sendService.sendHtmlEmail(id, attachmentId));
    }

    @PostMapping("/html/{id}/execution")
    public Message sendHtmlEmailById(@PathVariable(value = "id") String id) {
        return PackageInfo.packageSuccess(sendService.sendHtmlEmail(id));
    }

    @PostMapping("/simple/{id}/execution")
    public Message sendSimpleEmailById(@PathVariable(value = "id") String id) {
        return PackageInfo.packageSuccess(sendService.sendSimpleEmail(id));
    }

    @PostMapping("/htmlWithAttachment/execution")
    public Message sendHtmlEmailWithAttachment(@RequestBody HtmlEmail htmlEmail) {
        return PackageInfo.packageSuccess(sendService.sendHtmlEmail(htmlEmail, htmlEmail.getAttachment().getId()));
    }

    @PostMapping("/html/execution")
    public Message sendHtmlEmail(@RequestBody HtmlEmail htmlEmail) {
        return PackageInfo.packageSuccess(sendService.sendHtmlEmail(htmlEmail));
    }

    @PostMapping("/simple/execution")
    public Message sendSimpleEmail(@RequestBody SimpleEmail simpleEmail) {
        return PackageInfo.packageSuccess(sendService.sendSimpleEmail(simpleEmail));
    }

}

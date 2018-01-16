package com.jwebcoder.emailsystem.controller;

import com.jwebcoder.emailsystem.dto.Message;
import com.jwebcoder.emailsystem.service.SendService;
import com.jwebcoder.emailsystem.utility.PackageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class SendEmailController {

    @Autowired
    private SendService sendService;

    @PostMapping("/html/{id}/{attachmentId}/execution")
    public Message sendHtmlEmailWithAttachment(@PathVariable("id") String id, @PathVariable(value = "attachmentId", required = false) String attachmentId) {
        return PackageInfo.packageSuccess(null);
    }

    @PostMapping("/html/{id}/execution")
    public Message sendHtmlEmail(@PathVariable("id") String id) {
        return PackageInfo.packageSuccess(null);
    }

    @PostMapping("/simple/{id}/execution")
    public Message sendSimpleEmail(@PathVariable("id") String id) {
        return PackageInfo.packageSuccess(null);
    }

}

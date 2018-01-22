package com.jwebcoder.emailsystem.service;

public interface ReceiveFromActiveMQService {

    void receiveTopicText(String message);
    void receiveTopicObject(String message);

    void receiveQueueText(String message);
    void receiveQueueObject(String message);

}

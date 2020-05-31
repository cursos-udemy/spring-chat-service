package com.jendrix.udemy.spring5.chat.services.impl;

import com.jendrix.udemy.spring5.chat.models.documents.Message;
import com.jendrix.udemy.spring5.chat.repositories.MessageRepository;
import com.jendrix.udemy.spring5.chat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Iterable<Message> findFirst10ByOrOrderByTimeDesc() {
        return this.messageRepository.findFirst10ByOrderByTimeDesc();
    }

    @Override
    public Message save(Message message) {
        return this.messageRepository.save(message);
    }
}

package com.jendrix.udemy.spring5.chat.services;

import com.jendrix.udemy.spring5.chat.models.documents.Message;

public interface MessageService {


    public Iterable<Message> findFirst10ByOrOrderByTimeDesc();

    public Message save(Message message);

}

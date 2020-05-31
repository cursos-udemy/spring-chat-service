package com.jendrix.udemy.spring5.chat.repositories;

import com.jendrix.udemy.spring5.chat.models.documents.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {


    public Iterable<Message> findFirst10ByOrderByTimeDesc();
}

package com.jendrix.udemy.spring5.chat.models.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@Document(collection = "messages")
public class Message implements Serializable {

    @Id
    private String id;

    private String text;
    private Long time;
    private String username;
    private String color;
    private String type;

}

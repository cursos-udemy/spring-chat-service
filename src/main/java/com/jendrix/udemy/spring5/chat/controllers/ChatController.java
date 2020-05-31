package com.jendrix.udemy.spring5.chat.controllers;

import com.jendrix.udemy.spring5.chat.models.documents.Message;
import com.jendrix.udemy.spring5.chat.services.MessageService;
import com.jendrix.udemy.spring5.chat.utils.ColorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/chat/malbec-runners")
    public Message receiveMessage(Message message) {
        message.setTime(new Date().getTime());
        if ("LOGIN".equals(message.getType())) {
            message.setText(message.getUsername().concat(" a ingresado"));
            message.setColor(ColorUtils.getHtmlColorRandom());
        } else {
            this.messageService.save(message);
        }
        return message;
    }

    @MessageMapping("/writing")
    @SendTo("/chat/malbec-runners-writing")
    public String isWriting(String username) {
        return String.format("%s esta escribiendo ...", username);
    }

    @MessageMapping("/malbec-runners-history")
    @SendTo("/chat/malbec-runners-history")
    public void geHistory(String clientId) {
        String destination = String.format("/chat/malbec-runners-history/%s", clientId);
        this.simpMessagingTemplate.convertAndSend(destination, this.messageService.findFirst10ByOrOrderByTimeDesc());
    }
}

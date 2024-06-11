package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Chatmsg;



@Controller
public class chatcontroller {
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public Chatmsg register(@Payload Chatmsg chatMsg,SimpMessageHeaderAccessor headerAccesser) {
		headerAccesser.getSessionAttributes().put("username", chatMsg.getSender());
		return chatMsg;
	}
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public Chatmsg sendMessage(@Payload Chatmsg chatMessage) {
		return chatMessage;
		
	}
}

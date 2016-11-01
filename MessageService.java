package org.kaushik.javabrains.messanger.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.kaushik.javabrains.messanger.database.*;
import org.kaushik.javabrains.messanger.exceptions.DataNotFoundException;
import org.kaushik.javabrains.messanger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public  MessageService() {
		messages.put(1L,new Message(1, "Swaggers","Link to All the Swaggers till now",(new java.util.Date())));
		messages.put(2L,new Message(2, "USA","Skywalker!",(new java.util.Date())));
		messages.put(3L,new Message(3,"USA","FUSION",(new java.util.Date()) ));
		messages.put(4L,new Message(4, "Singapore/USA","Trusted Identities & Platform",(new java.util.Date())));

	}
/*	public List<Message> getAllMessages() {
		Message M1 =  new Message(1L,"Hello World!",null, "Koushik");
		Message M2 =  new Message(2L,"Hello World!",null, "Koushik");
		List <Message> list =new ArrayList<>();
		list.add(M1);
		list.add(M2);
		return list;
	}*/
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	
	public Message getMessage(Long id){
		Message message = messages.get(id);
		if(message == null)
		{
			throw new DataNotFoundException("Message is "+ id + "not found");
		}
		System.out.println("Inside the getMessage Message Service "+id);
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		System.out.println("Inside Message Service Add Message Size"+messages.size());
		message.setId(messages.size()+1);
		System.out.println("Inside Message Service Get Message Id"+message.getId());
		System.out.println("Inside Message Service Add Message Size"+message.toString());		
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message,long messageId){

		System.out.println("Inside Message Service PUT Message Id"+message.getId());
		System.out.println("Inside Message Service PUT Message Size"+message.toString());		
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message deleteMessage(Message message){

		System.out.println("Inside Message Service DELETE Message Id"+message.getId());
		System.out.println("Inside Message Service DELETE Message "+message.toString());		
		messages.remove(message.getId());
		return message;
	}
	
}

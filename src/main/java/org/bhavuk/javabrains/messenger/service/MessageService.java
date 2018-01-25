package org.bhavuk.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bhavuk.javabrains.messenger.database.DatabaseClass;
import org.bhavuk.javabrains.messenger.model.Message;

public class MessageService 
{
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		
		messages.put(1L, new Message(1, "Seiko", "Bhavuk"));
		messages.put(2L, new Message(2, "Rolex", "Bhavuk"));
		
	}
	
	public List<Message> getAllMessages()
	{
		return new ArrayList<Message>(messages.values()); 
	}

	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		message.setCreated(new Date()); //added date automatically when created, so no need to specify in JSON
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		message.setCreated(new Date()); //added date automatically when updated, so no need to specify in JSON
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
	
}

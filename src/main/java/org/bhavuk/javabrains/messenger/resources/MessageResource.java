package org.bhavuk.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bhavuk.javabrains.messenger.model.Message;
import org.bhavuk.javabrains.messenger.service.MessageService;


@Path("/messages")
public class MessageResource 
{
	MessageService messageService = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() 
	{
		return messageService.getAllMessages();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return	messageService.addMessage(message);
	}
	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id) 
	{
		return messageService.getMessage(id);
 		
	}
}

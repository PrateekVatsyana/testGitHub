package org.kaushik.javabrains.messanger.resources;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Decoder;

import org.kaushik.javabrains.messanger.model.Message;
import org.kaushik.javabrains.messanger.service.MessageService;
@Path("/messages")
public class MessageResouce extends  HttpServlet{
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	MessageService  messageService = new MessageService();
	String decoded ;
	String contentType;
	String clientId;
	String acceptLanguage;
	@GET    
    @Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages()
	{
    	return messageService.getAllMessages();
	}

	
	/*@GET    
    @Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessagesforYear(int year)
	{
    	return messageService.getAllMessages();
	}

	@GET    
    @Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessagesPaginated(int start,int size)
	{
    	return messageService.getAllMessages();
	}*/
	
	
   /* @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message addMessage(Message message){
		System.out.println("@POST method ");
		return messageService.addMessage(message);
    }*/    
    	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMessage(Message message){
		System.out.println("@POST method ");
		Message newMessage = messageService.addMessage(message);
		System.out.println("Status is "+Status.CREATED);
		return Response.status(Status.CREATED).entity(newMessage).build();
		//return messageService.addMessage(message);
    }
    
    
    
    @PUT
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") long messageId,Message message){
		System.out.println("@PUT method ");
		message.setId(messageId);
		return messageService.updateMessage(message,messageId);
    }
    
    
    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message deleteMessage(@PathParam("messageId") long messageId,Message message){
		System.out.println("@DELETE method ");
		message.setId(messageId);
		return messageService.deleteMessage(message);
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{messageId}")
	public Message getMessage(@Context HttpHeaders httpHeaders, @PathParam("messageId") long messageId,
			@Context UriInfo uriInfo,@Context HttpServletResponse  httpresponse)	{
	 		Message message = 	messageService.getMessage(messageId);
	 		
	 			
		 			System.out.println(" Request Path is  "+uriInfo.getPath().toString());
		 			System.out.println(" Basic path param  is  "+uriInfo.getPathParameters().toString());
		 			System.out.println(" Request header is "+httpHeaders.getHeaderString("Authorization"));
		 			System.out.println(" All Headers"+httpHeaders.getRequestHeaders());
		 				
		 			
		 		contentType = 	httpHeaders.getHeaderString("Content-Type");
		 		
		 		acceptLanguage = httpHeaders.getHeaderString("Accept-Language");
		 		clientId = httpHeaders.getHeaderString("clientId");
		 		
		 		
		 		System.out.println("contentType  "+contentType);
		 		System.out.println("acceptc Language  "+acceptLanguage);
		 		System.out.println("clientId  "+clientId);
		 		decoded = authenticateHTTPHeader(httpHeaders);
		 		
		 		System.out.println(" Inside authenticateHTTPHeader"+decoded.split(":", 2));
	 			
		 		String[] reqArray = decoded.split(":", 2);
		 		
		 		
	 		if(reqArray[0].equals("prateek")){
		 			
			 		if(reqArray[1].equals("rishabh")){
			 				System.out.println(" Successfuly Validated");
			 				 message.addLink(getUriforRaintree(uriInfo, message), "Raintree");
			    			 message.addLink(getUriforSkywalker(uriInfo, message), "Skywalker");
					 		 message.addLink(getUriforFusion(uriInfo, message), "Fusion");
			 		 		 message.addLink(getUriforPlatform(uriInfo, message), "Platform");
			 		}else{
			 			message.setMessage("Authentication failed ");
			 		}
		 		}else{

		 			message.setMessage("Authentication failed ");
		 		}
		 		
		 	
 		 		/* System.out.println(" Get "+uriInfo.getBaseUriBuilder().toString());
 		 		 System.out.println("Get only Path "+uriInfo.getBaseUriBuilder().path(MessageResouce.class).toString());
 		 		 System.out.println("Get only Path with Id "+uriInfo.getBaseUriBuilder().path(MessageResouce.class).path(Long.toString(message.getId())));*/
 		 		 return message;
 		 			
	}


	private String getUriforRaintree(UriInfo uriInfo, Message message) {
		//String uri = uriInfo.getBaseUriBuilder().path(MessageResouce.class).path(Long.toString(message.getId())).build().toString();
		String uri = "https://gtgtc-apila01d.nam.nsroot.net:20000/nga";
		return uri;
	}
    
	private String getUriforSkywalker(UriInfo uriInfo, Message message) {
		//String uri = uriInfo.getBaseUriBuilder().path(MessageResouce.class).path(Long.toString(message.getId())).build().toString();
		String uri = "https://gtgtc-apila01d.nam.nsroot.net:20000/nga";
		return uri;
	}
	
	private String getUriforFusion(UriInfo uriInfo, Message message) {
		//String uri = uriInfo.getBaseUriBuilder().path(MessageResouce.class).path(Long.toString(message.getId())).build().toString();
		
		String uri = "https://gtcrs-fuslw02t.nam.nsroot.net:20000/swagger-ui-2.1/";	
		return uri;
	}
	
	private String getUriforPlatform(UriInfo uriInfo, Message message) {
		//String uri = uriInfo.getBaseUriBuilder().path(MessageResouce.class).path(Long.toString(message.getId())).build().toString();
		String uri = "https://apis-ccp.citibank.nam.nsroot.net:20000/swagger-ui-master/index.html";
		return uri;
	}
	
    
    @Path("/{messageId}/comments")
    public CommentResource getCommentResource(@PathParam("messageId") long messageId){   
    	System.out.println("messageId is  "+messageId);
    	return new CommentResource();
    }
    
    
    
    public String authenticateHTTPHeader(HttpHeaders httpHeaders){
    	
    	System.out.println(" Inside authenticateHTTPHeader");
    		try{
    			// Get the Authorization Header from Request
    			String header = httpHeaders.getHeaderString("authorization");
    	    	System.out.println(" HEADER VALUE in authenticateHTTPHeader"+header);
    			// Header is in the format "Basic 3nc0dedDat4"
    			// We need to extract data before decoding it back to original string
    			String data = header.substring(header.indexOf(" ") +1 );
    			// Decode the data back to original string
    			byte[] bytes = new BASE64Decoder().decodeBuffer(data);
    			decoded = new String(bytes);
    			System.out.println(" Decoded String "+decoded);
    		}
    		catch(Exception e){
    			e.printStackTrace();
    			decoded = "No/Invalid authentication information provided";
    		}
    		
    		
    		return decoded;
    	}
}

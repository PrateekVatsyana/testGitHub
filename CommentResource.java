package org.kaushik.javabrains.messanger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kaushik.javabrains.messanger.model.Message;

@Path("/")
public class CommentResource {

	
	@GET
	public String test(){
		System.out.println("Inside CommentResource");
		return "new Sub Resurce";
	}
	
	
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path("/{commentId}")
		public String getComment(@PathParam("commentId") long commentID,@PathParam("messageId") long messageId)
		{
	 		 System.out.println("Inside the getComment Comment Resource "+commentID);
	 		
	 			 	return  "Inside the getComment Comment Resource "+commentID +"For "+ messageId;
	 		
		}
}

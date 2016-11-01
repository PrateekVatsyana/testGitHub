package org.kaushik.javabrains.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kaushik.javabrains.messanger.model.Message;
import org.kaushik.javabrains.messanger.model.Profile;
import org.kaushik.javabrains.messanger.service.ProfileService;

@Path("/profile")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profileService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles(){
		System.out.println(" inside profiles");
		return profileService.getAllProfiles();
	}
	
	 @POST
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Profile addProfile(Profile Profile){
			System.out.println("@POST method ");
			return profileService.addProfile(Profile);
	    }
	    
	    	
	    @PUT
	    @Path("/{profileName}")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Profile updateProfile(@PathParam("profileName") String  profileName,Profile profile){
			System.out.println("@PUT method ");
			profile.setProfileName(profileName);
			return profileService.updateProfile(profile);
	    } 	
	    
	    
	    @DELETE
	    @Path("/{profileName}")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Profile deleteProfile(@PathParam("profileName") String  profileName,Profile profile){
			System.out.println("@DELETE method ");
			profile.setProfileName(profileName);
			return profileService.removeProfile(profileName);
	    }
	    
	    
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    @Path("/{profileName}")
		public Profile getProfile(@PathParam("profileName") String  profileName)
		{
	 		 System.out.println("Inside the getMessages Message Resource "+profileName);
	    	 return  profileService.getProfile(profileName);
		}
		
	}


package org.kaushik.javabrains.messanger.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.kaushik.javabrains.messanger.database.*;
import org.kaushik.javabrains.messanger.model.*;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
public  ProfileService() {
		profiles.put("Brahmin",new Profile(1L,"Prateek","Watsyaen","Sharma",(new java.util.Date())));	
	}

	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	
	public Profile getProfile(String profileName){
		System.out.println("Inside the getProfile Profile Service"+profileName);
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		System.out.println("Inside Profile ServiceAdd Profile Size"+profiles.size());
		profile.setId(profiles.size()+1);
		System.out.println("Inside Profile ServiceAdd Profile Size"+profile.toString());		
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		System.out.println("Inside Profile ServicePUT Profile Size"+profile.toString());		
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){

		System.out.println("profileName  in Remove profile"+profileName);
		return profiles.remove(profileName);
	}
	
}

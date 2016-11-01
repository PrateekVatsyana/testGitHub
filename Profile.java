package org.kaushik.javabrains.messanger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Profile {
	private long id;
	private String profileName;
	private String firstName;
	private String lasttName ;
	private Date  creaed;
	
	public Profile() {
	
	}
	
	public Profile(long id, String profileName, String firstName, String lasttName, Date creaed) {
		this.id = id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lasttName = lasttName;
		this.creaed = creaed;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasttName() {
		return lasttName;
	}
	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}
	public Date getCreaed() {
		return creaed;
	}
	public void setCreaed(Date creaed) {
		this.creaed = creaed;
	}
	
	
	
}
package org.kaushik.javabrains.messanger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Message {

	private long id;
	private String Swaggers ;
	private String message;
	private Date created ;

	private List<Link> links = new ArrayList<>();
	public List<Link> getLinks() {
		System.out.println("Links in get link ");
		return links;
	}

	public void setLinks(List<Link> links) {
		System.out.println("Links in get link ");
		this.links = links;
	}

	public Message() {
		
	}
	
	/*  Constructor for Class */
	public Message(long id,String Swaggers,String message,Date created) {
		this.id = id;
		this.message = message;
		this.created = created;
		this.Swaggers = Swaggers;
	}
	
	public String getSwaggers() {
		return Swaggers;
	}
	public void setSwaggers(String Swaggers) {
		this.Swaggers = Swaggers;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
		
	public void addLink(String url,String rel){
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		
		//System.out.println(" Inside Add Refernce"+rel);
		links.add(link);
		
	}
	
	
}

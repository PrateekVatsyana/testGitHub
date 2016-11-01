package org.kaushik.javabrains.messanger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {


	
	
	  public ErrorMessage(String errorMessage, String documentation, int errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.documentation = documentation;
		ErrorCode = errorCode;
	}
	  
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	public int getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(int errorCode) {
		ErrorCode = errorCode;
	}
	private String errorMessage;
	  private String documentation;
	  private int ErrorCode;	  
}

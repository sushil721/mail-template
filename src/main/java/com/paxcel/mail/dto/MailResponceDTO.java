package com.paxcel.mail.dto;

import java.util.Map;

import org.springframework.http.HttpStatus;

public class MailResponceDTO {
	
	private Map<String,String> responseMessages;
	private HttpStatus responseCode;
	private String responseDesc;
	
	public MailResponceDTO() {
		super();
	}
	
	public MailResponceDTO(Map<String, String> responseMessages, HttpStatus responseCode, String responseDesc) {
		super();
		this.responseMessages = responseMessages;
		this.responseCode = responseCode;
		this.responseDesc = responseDesc;
	}
	
	public Map<String, String> getResponseMessages() {
		return responseMessages;
	}
	public void setResponseMessages(Map<String, String> responseMessages) {
		this.responseMessages = responseMessages;
	}
	public HttpStatus getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseDesc() {
		return responseDesc;
	}
	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	
}

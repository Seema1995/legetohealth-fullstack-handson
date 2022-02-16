
package com.legatohealth.beans;

import org.springframework.http.HttpStatus;

public class CustomMessage {
	private String info;
	private HttpStatus message;
	
	public CustomMessage(String info, HttpStatus message) {
		this.info = info;
		this.message = message;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public HttpStatus getMessage() {
		return message;
	}
	public void setMessage(HttpStatus message) {
		this.message = message;
	}
	

}

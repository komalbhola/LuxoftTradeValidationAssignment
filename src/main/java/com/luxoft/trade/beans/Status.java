package com.luxoft.trade.beans;

public class Status {

	private Integer code;
	private String message;
	
	public Status(){
		
	}
	
	public Status(Integer code, String message){
		super();
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

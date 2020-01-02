package com.email.demo.response;

import java.io.Serializable;
import java.util.List;

import com.email.demo.model.EmailModel;

public class EmailResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<EmailModel> models;
	
	private String message;
	
	private int statusCode;
	
	private String errorMessage;

	public List<EmailModel> getModel() {
		return models;
	}

	public void setModel(List<EmailModel> models) {
		this.models = models;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	} 
	
	
	

}

package com.vedantu.exception;

public class AppRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -7689964299854752518L;
	
	private String error;
	
	public AppRuntimeException(String error) {
		super();
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}

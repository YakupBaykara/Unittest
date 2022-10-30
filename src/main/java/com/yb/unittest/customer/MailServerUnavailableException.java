package com.yb.unittest.customer;

public class MailServerUnavailableException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MailServerUnavailableException(String message) {
        super(message);
    }
}

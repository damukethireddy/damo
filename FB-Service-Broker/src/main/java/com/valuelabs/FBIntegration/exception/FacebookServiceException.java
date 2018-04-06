package com.valuelabs.FBIntegration.exception;

import org.springframework.cloud.servicebroker.exception.ServiceBrokerException;

public class FacebookServiceException extends ServiceBrokerException {

	private static final long serialVersionUID = 8667141725171626000L;

	public FacebookServiceException(String message) {
		super(message);
	}
}

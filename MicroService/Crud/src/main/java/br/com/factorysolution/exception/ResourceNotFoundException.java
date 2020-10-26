package br.com.factorysolution.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7386491738662785100L;

	public ResourceNotFoundException(String exception) {
		super(exception);
	}
}
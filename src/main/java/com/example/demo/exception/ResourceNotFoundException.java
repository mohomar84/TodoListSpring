package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
    private long id;
    
    public ResourceNotFoundException( long id) {
    	super(String.format("The Item is not found with id : '%s'", id));

    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

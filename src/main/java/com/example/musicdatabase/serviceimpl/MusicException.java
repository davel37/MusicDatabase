package com.example.musicdatabase.serviceimpl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MusicException extends RuntimeException {

	  public MusicException(String message) {
	        super(message);
	    }

    public MusicException(String message, Throwable cause) {
	        super(message, cause);
	    }


	}




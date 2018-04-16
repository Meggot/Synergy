package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by bradleyw on 16/04/2018.
 */
@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
public class DatabaseErrorException extends RuntimeException{
    public DatabaseErrorException(String message) {
        super(message);
    }
}

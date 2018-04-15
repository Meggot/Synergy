package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by bradleyw on 15/04/2018.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class NoDataFoundException extends RuntimeException{

    public NoDataFoundException(String message) {
        super(message);
    }
}

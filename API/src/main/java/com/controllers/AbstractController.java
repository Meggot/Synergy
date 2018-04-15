package com.controllers;

import com.abstracts.SynergyResponse;
import com.exceptions.NoDataFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by bradleyw on 15/04/2018.
 */
@RestController
public abstract class AbstractController {

    @ExceptionHandler(NoDataFoundException.class)
    @ResponseBody
    protected String handleNoDataFoundException(NoDataFoundException ex) {
        return ex.getMessage();
    }

}

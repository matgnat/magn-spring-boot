package com.magn.magnspringboot.apicontroller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by magn on 4/11/2018.
 */
//@ControllerAdvice(annotations = RestController.class)
public class UserControllerAdvice {

    String errorMessage;

    public UserControllerAdvice(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "UserControllerAdvice{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}

package com.javainuse.springbootsecurity.model.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
     private String msg;

    public NotFoundException() {
    }

    public NotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}

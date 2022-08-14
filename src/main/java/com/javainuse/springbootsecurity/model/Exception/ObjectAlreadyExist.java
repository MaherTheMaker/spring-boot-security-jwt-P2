package com.javainuse.springbootsecurity.model.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ObjectAlreadyExist extends RuntimeException {

        private String message;

    public ObjectAlreadyExist() {}

    public ObjectAlreadyExist(String msg)
        {
            super(msg);
            this.message = msg;
        }

}

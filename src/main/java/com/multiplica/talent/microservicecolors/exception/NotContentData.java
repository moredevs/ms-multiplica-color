package com.multiplica.talent.microservicecolors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NotContentData  extends  RuntimeException{

    public  NotContentData(String message) {
        super(message);
    }
}


package com.upwirk.upwirk_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class UpwirdException extends Throwable {
    public UpwirdException(String message) {
        super(message);
    }
}

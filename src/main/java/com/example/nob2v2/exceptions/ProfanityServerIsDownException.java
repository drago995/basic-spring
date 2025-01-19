package com.example.nob2v2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.GONE)
public class ProfanityServerIsDownException extends RuntimeException {

    public ProfanityServerIsDownException(String message) {
        super(message);
    }
}

package com.example.nob2v2;

import org.springframework.http.ResponseEntity;

public interface Command <I,O>{

    ResponseEntity<O> execute(I input);
}

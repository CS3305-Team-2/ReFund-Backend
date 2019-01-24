package com.bestteam.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response<T> extends ResponseEntity<T> {
    public Response(T content) {
        super(content, HttpStatus.OK);
    }

    public Response(T content, HttpStatus status) {
        super(content, status);
    }

    public Response(HttpStatus status) {
        super((T)null, status);
    }
}
package com.dev.sayan.ridehailing.ridehailingmonolith.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

package com.example.project.exception;

public class PartnerNotFoundException extends RuntimeException {
    public PartnerNotFoundException(Long id) {
        super ("Partner with id" + id + " does not exist");
    }
}

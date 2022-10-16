package com.example.creasy.exception;

public class CompanyNotFoundException extends RuntimeException {

    public CompanyNotFoundException(long id) {
        super("Company with id " + id + " does not exist");
    }
}

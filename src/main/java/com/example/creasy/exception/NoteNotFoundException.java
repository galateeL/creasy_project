package com.example.creasy.exception;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(long id) {

        super("Note with id " + id + " does not exist");
    }
}

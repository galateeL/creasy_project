package com.example.creasy.controller.dto;

public class EditNoteDto {

    private String exchange;



    public EditNoteDto() {
    }

    public EditNoteDto(String exchange) {
        this.exchange = exchange;

    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }



}

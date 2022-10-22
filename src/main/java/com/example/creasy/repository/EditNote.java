package com.example.creasy.repository;

import com.example.creasy.repository.entity.Partner;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class EditNote {

    private String exchange;



    public EditNote() {
    }

    public EditNote(String exchange) {
        this.exchange = exchange;

    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }



}

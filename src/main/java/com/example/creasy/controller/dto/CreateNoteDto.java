package com.example.creasy.controller.dto;

import com.example.creasy.model.Note;
import com.example.creasy.model.Partner;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class CreateNoteDto {

    private String exchange;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime registerDate;



    public CreateNoteDto() {
    }

    public Note toNote() {
        Note n = new Note();
        n.setExchange(this.exchange);
        n.setRegisterDate(this.registerDate);
        return n;
    }

    public CreateNoteDto(String exchange, LocalDateTime registerDate, Partner partner) {
        this.exchange = exchange;
        this.registerDate = registerDate;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

}

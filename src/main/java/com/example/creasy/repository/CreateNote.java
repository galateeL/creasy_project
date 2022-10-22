package com.example.creasy.repository;

import com.example.creasy.repository.entity.Note;
import com.example.creasy.repository.entity.Partner;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class CreateNote {

    private String exchange;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime registerDate;



    public CreateNote() {
    }

    public Note toNote() {
        Note n = new Note();
        n.setExchange(this.exchange);
        n.setRegisterDate(this.registerDate);
        return n;
    }

    public CreateNote(String exchange, LocalDateTime registerDate, Partner partner) {
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

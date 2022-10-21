package com.example.creasy.repository;

import com.example.creasy.repository.entity.Note;
import com.example.creasy.repository.entity.Partner;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CreateNote {

    private String exchange;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registerDate;



    public CreateNote() {
    }

    public Note toNote() {
        Note n = new Note();
        n.setExchange(this.exchange);
        n.setRegisterDate(this.registerDate);
        return n;
    }

    public CreateNote(String exchange, LocalDate registerDate, Partner partner) {
        this.exchange = exchange;
        this.registerDate = registerDate;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

}

package com.example.creasy.repository;

import com.example.creasy.repository.entity.Partner;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EditNote {

    private String exchange;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registerDate;

    private Partner partner;

    public EditNote() {
    }

    public EditNote(String exchange, LocalDate registerDate, Partner partner) {
        this.exchange = exchange;
        this.registerDate = registerDate;
        this.partner = partner;
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

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}

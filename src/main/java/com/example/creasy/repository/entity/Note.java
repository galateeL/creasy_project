package com.example.creasy.repository.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String exchange;

    private LocalDateTime registerDate;

    @ManyToOne
    private Partner partner;

    public Note() {
    }

    public Note(Long id, String exchange, LocalDateTime registerDate, Partner partner) {
        this.id = id;
        this.exchange = exchange;
        this.registerDate = registerDate;
        this.partner = partner;
    }

    public Note(String exchange, LocalDateTime registerDate, Partner partner) {
        this.exchange = exchange;
        this.registerDate = registerDate;
        this.partner = partner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}

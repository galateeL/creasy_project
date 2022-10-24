package com.example.creasy.repository;

import com.example.creasy.repository.entity.StateProspect;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreateDunning {

    private int dunningPeriod;

    //@DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime registerDateDunning;

    private StateProspect stateProspect;


    public CreateDunning() {
    }

    public CreateDunning(int dunningPeriod, LocalDateTime registerDateDunning, StateProspect stateProspect) {
        this.dunningPeriod = dunningPeriod;
        this.registerDateDunning = registerDateDunning;
        this.stateProspect = stateProspect;
    }

    public int getDunningPeriod() {
        return dunningPeriod;
    }

    public void setDunningPeriod(int dunningPeriod) {
        this.dunningPeriod = dunningPeriod;
    }

    public LocalDateTime getRegisterDateDunning() {
        return registerDateDunning;
    }

    public void setRegisterDateDunning(LocalDateTime registerDateDunning) {
        this.registerDateDunning = registerDateDunning;
    }

    public StateProspect getStateProspect() {
        return stateProspect;
    }

    public void setStateProspect(StateProspect stateProspect) {
        this.stateProspect = stateProspect;
    }
}

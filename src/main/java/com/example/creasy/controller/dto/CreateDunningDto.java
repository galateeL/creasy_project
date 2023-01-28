package com.example.creasy.controller.dto;

import com.example.creasy.model.StateProspect;

import java.time.LocalDateTime;

public class CreateDunningDto {

    private int dunningPeriod;

    //@DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime registerDateDunning;

    private StateProspect stateProspect;


    public CreateDunningDto() {
    }

    public CreateDunningDto(int dunningPeriod, LocalDateTime registerDateDunning, StateProspect stateProspect) {
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

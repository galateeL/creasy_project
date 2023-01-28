package com.example.creasy.controller.dto;

import com.example.creasy.model.Company;
import com.example.creasy.model.Partner;
import com.example.creasy.model.StateProspect;
import com.example.creasy.model.User;

import java.time.LocalDateTime;

public class CreatePartnerDto {

    private String lastname;

    private String firstname;

    private String email;

    private String pictureUrl;

    private String fixedPhoneNumber;

    private String mobilePhoneNumber;

    private String positionHeld;

    private StateProspect stateProspect;

    private Company company;

    private LocalDateTime registerDate;

    private User user;



    public CreatePartnerDto() {
    }

    public Partner toPartner() {
        Partner p = new Partner();
        p.setFirstname(this.firstname);
        p.setLastname(this.lastname);
        p.setEmail(this.email);
        p.setPictureUrl(this.pictureUrl);
        p.setFixedPhoneNumber(this.fixedPhoneNumber);
        p.setMobilePhoneNumber(this.mobilePhoneNumber);
        p.setPositionHeld(this.positionHeld);
        p.setStateProspect(this.stateProspect);
        p.setCompany(this.company);

        return p;

    }

    public CreatePartnerDto(String lastname, String firstname, String email, String pictureUrl, String fixedPhoneNumber, String mobilePhoneNumber, String positionHeld, StateProspect stateProspect) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.pictureUrl = pictureUrl;
        this.fixedPhoneNumber = fixedPhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.positionHeld = positionHeld;
        this.stateProspect = stateProspect;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getFixedPhoneNumber() {
        return fixedPhoneNumber;
    }

    public void setFixedPhoneNumber(String fixedPhoneNumber) {
        this.fixedPhoneNumber = fixedPhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getPositionHeld() {
        return positionHeld;
    }

    public void setPositionHeld(String positionHeld) {
        this.positionHeld = positionHeld;
    }

    public StateProspect getStateProspect() {
        return stateProspect;
    }

    public void setStateProspect(StateProspect stateProspect) {
        this.stateProspect = stateProspect;
    }
}

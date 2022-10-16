package com.example.project.repository;

import com.example.project.repository.entity.Partner;
import com.example.project.repository.entity.StateProspect;

public class CreatePartner {

    private String lastname;

    private String firstname;

    private String email;

    private String pictureUrl;

    private String fixedPhoneNumber;

    private String mobilePhoneNumber;

    private String positionHeld;

// private boolean isClient;

    private StateProspect stateProspect;


    public CreatePartner() {
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

        return p;

    }

    public CreatePartner(String lastname, String firstname, String email, String address, String pictureUrl, String fixedPhoneNumber, String mobilePhoneNumber, String positionHeld, StateProspect stateProspect) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.pictureUrl = pictureUrl;
        this.fixedPhoneNumber = fixedPhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.positionHeld = positionHeld;
        this.stateProspect = stateProspect;
    }

//    public boolean isClient() {
//        return isClient;
//    }
//
//    public void setClient(boolean client) {
//        isClient = client;
//    }

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

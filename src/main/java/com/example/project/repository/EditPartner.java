package com.example.project.repository;

public class EditPartner {

    private int id;

    private String lastname;

    private String firstname;

    private String email;

    private String address;

    private String pictureUrl;

    private String fixedPhoneNumber;

    private String mobilePhoneNumber;

    private String positionHeld;

    private boolean isClient;

    private String stateProspect;

    public EditPartner() {
    }

    public EditPartner(int id, String lastname, String firstname, String email, String address, String pictureUrl, String fixedPhoneNumber, String mobilePhoneNumber, String positionHeld, boolean isClient, String stateProspect) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.address = address;
        this.pictureUrl = pictureUrl;
        this.fixedPhoneNumber = fixedPhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.positionHeld = positionHeld;
        this.isClient = isClient;
        this.stateProspect = stateProspect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public boolean isClient() {
        return isClient;
    }

    public void setClient(boolean client) {
        isClient = client;
    }

    public String getStateProspect() {
        return stateProspect;
    }

    public void setStateProspect(String stateProspect) {
        this.stateProspect = stateProspect;
    }
}

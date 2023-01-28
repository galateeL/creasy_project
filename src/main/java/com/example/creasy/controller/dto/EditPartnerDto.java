package com.example.creasy.controller.dto;

import com.example.creasy.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public class EditPartnerDto {

    private int id;

    private String lastname;

    private String firstname;

    private String email;

    private String pictureUrl;

    private MultipartFile pictureFile;

    private String fixedPhoneNumber;

    private String mobilePhoneNumber;

    private String positionHeld;


    private String stateProspect;

    private String companyId;

    private User user;




    private int dunningPeriod;

    private LocalDateTime dunningRegisterDate;

    public int getDunningPeriod() {
        return dunningPeriod;
    }

    public void setDunningPeriod(int dunningPeriod) {
        this.dunningPeriod = dunningPeriod;
    }

    public LocalDateTime getDunningRegisterDate() {
        return dunningRegisterDate;
    }

    public void setDunningRegisterDate(LocalDateTime dunningRegisterDate) {
        this.dunningRegisterDate = dunningRegisterDate;
    }



    public MultipartFile getPictureFile() {
        return pictureFile;
    }

    public void setPictureFile(MultipartFile pictureFile) {
        this.pictureFile = pictureFile;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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

    public String getStateProspect() {
        return stateProspect;
    }

    public void setStateProspect(String stateProspect) {
        this.stateProspect = stateProspect;
    }
}

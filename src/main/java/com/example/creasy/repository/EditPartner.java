package com.example.creasy.repository;

import com.example.creasy.repository.entity.Company;
import com.example.creasy.repository.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public class EditPartner {

    private int id;

    private String lastname;

    private String firstname;

    private String email;

    private String pictureUrl;

    private MultipartFile pictureFile;

    private String fixedPhoneNumber;

    private String mobilePhoneNumber;

    private String positionHeld;

    //private boolean isClient;

    private String stateProspect;

    private String companyId;

    private User user;




    private int dunningPeriod;

    private LocalDateTime dunningRegisterDate;




    public EditPartner() {
    }

    public EditPartner(int id, String lastname, String firstname, String email, String pictureUrl, String fixedPhoneNumber, String mobilePhoneNumber, String positionHeld, String stateProspect, String companyId) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.pictureUrl = pictureUrl;
        this.fixedPhoneNumber = fixedPhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.positionHeld = positionHeld;
        //this.isClient = isClient;
        this.stateProspect = stateProspect;
        this.companyId = companyId;
    }



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

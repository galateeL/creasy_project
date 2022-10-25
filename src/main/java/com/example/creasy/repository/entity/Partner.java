package com.example.creasy.repository.entity;

import com.example.creasy.controller.dto.EventDto;
import com.example.creasy.controller.dto.MapCustomerDto;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastname;

    private String firstname;

    private String email;

    private String pictureUrl;

    private String fixedPhoneNumber;

    private String mobilePhoneNumber;

    private String positionHeld;


    private int dunningPeriod;

    private LocalDateTime dunningRegisterDate;


    @NotNull
    @Enumerated(EnumType.STRING)
    private StateProspect stateProspect;

    @ManyToOne
    private Company company;

    @ManyToOne
    private User user;


    @OneToMany(mappedBy = "partner")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Note> noteList;

    private LocalDateTime registerDate;

    public Partner() {
    }


    public Partner(Long id, String lastname, String firstname, String email, String pictureUrl, String fixedPhoneNumber, String mobilePhoneNumber, String positionHeld, StateProspect stateProspect, LocalDateTime registerDate) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.pictureUrl = pictureUrl;
        this.fixedPhoneNumber = fixedPhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.positionHeld = positionHeld;
        this.stateProspect = stateProspect;
        this.registerDate = registerDate;
    }

    public Partner(String lastname, String firstname, String email, String pictureUrl, String fixedPhoneNumber, String mobilePhoneNumber, String positionHeld, StateProspect stateProspect, LocalDateTime registerDate) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.pictureUrl = pictureUrl;
        this.fixedPhoneNumber = fixedPhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.positionHeld = positionHeld;
        this.stateProspect = stateProspect;
        this.registerDate = registerDate;
    }

    public Partner(String lastname, String firstname, String email, String pictureUrl, String fixedPhoneNumber, String mobilePhoneNumber, String positionHeld, StateProspect stateProspect, Company company, LocalDateTime registerDate) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.pictureUrl = pictureUrl;
        this.fixedPhoneNumber = fixedPhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.positionHeld = positionHeld;
        this.stateProspect = stateProspect;
        this.company = company;
        this.registerDate = registerDate;
    }

    public Partner(String lastname, String firstname, String email, String pictureUrl, String fixedPhoneNumber, String mobilePhoneNumber, String positionHeld, StateProspect stateProspect, Company company, List<Note> noteList, LocalDateTime registerDate) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.pictureUrl = pictureUrl;
        this.fixedPhoneNumber = fixedPhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.positionHeld = positionHeld;
        this.stateProspect = stateProspect;
        this.company = company;
        this.noteList = noteList;
        this.registerDate = registerDate;
    }

    public Partner(String lastname, String firstname, String email, String pictureUrl, String fixedPhoneNumber, String mobilePhoneNumber, String positionHeld, StateProspect stateProspect, Company company, User user, LocalDateTime registerDate) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.pictureUrl = pictureUrl;
        this.fixedPhoneNumber = fixedPhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.positionHeld = positionHeld;
        this.stateProspect = stateProspect;
        this.company = company;
        this.user = user;
        this.registerDate = registerDate;
    }
    public MapCustomerDto toMapCustomerDto() {
        MapCustomerDto mapCustomerDto = new MapCustomerDto();
        mapCustomerDto.setFirstName(this.firstname);
        mapCustomerDto.setId(this.id);
        mapCustomerDto.setLatitude(this.company.getLatitude());
        mapCustomerDto.setLongitude(this.company.getLongitude());


        return mapCustomerDto;
    }

    public Partner(String lastname, String firstname, String email, String pictureUrl, String fixedPhoneNumber, String mobilePhoneNumber, String positionHeld, int dunningPeriod, LocalDateTime dunningRegisterDate, StateProspect stateProspect, Company company, User user, List<Note> noteList, LocalDateTime registerDate) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.pictureUrl = pictureUrl;
        this.fixedPhoneNumber = fixedPhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.positionHeld = positionHeld;
        this.dunningPeriod = dunningPeriod;
        this.dunningRegisterDate = dunningRegisterDate;
        this.stateProspect = stateProspect;
        this.company = company;
        this.user = user;
        this.noteList = noteList;
        this.registerDate = registerDate;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public StateProspect getStateProspect() {
        return stateProspect;
    }

    public void setStateProspect(StateProspect stateProspect) {
        this.stateProspect = stateProspect;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

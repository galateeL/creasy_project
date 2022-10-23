package com.example.creasy.repository.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String email;

    private boolean admin;
    private String pictureUrl;
    private String password;

    private String lastName;

    private String firstName;

    @OneToMany(mappedBy = "user")
    private List<Partner> partnerList;

    public User() {
    }

    public User(Long id, String email, boolean admin, String pictureUrl, String password, String lastName,
                String firstName) {
        this.id = id;
        this.email = email;
        this.admin = admin;
        this.pictureUrl = pictureUrl;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public User(String email, boolean admin, String pictureUrl, String password, String lastName,
                String firstName) {
        this.email = email;
        this.admin = admin;
        this.pictureUrl = pictureUrl;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public User(String email, boolean admin, String pictureUrl, String password, String lastName, String firstName, List<Partner> partnerList) {
        this.email = email;
        this.admin = admin;
        this.pictureUrl = pictureUrl;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.partnerList = partnerList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public List<Partner> getPartnerList() {
        return partnerList;
    }

    public void setPartnerList(List<Partner> partnerList) {
        this.partnerList = partnerList;
    }
}


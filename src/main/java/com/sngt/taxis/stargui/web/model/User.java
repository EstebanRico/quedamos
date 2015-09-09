package com.sngt.taxis.stargui.web.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by skiss on 08/09/2015.
 */
public class User {


    public String id;
    public Date birthDate;
    public Date creationDate;
    public String nickName;
    public String surName;
    public String firstName;
    public String mail;
    public String location;
    public String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String picture;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void initTest() {
        id="12345678";
        birthDate = Calendar.getInstance().getTime();
        creationDate = Calendar.getInstance().getTime();
        nickName = "Nick Name";
        surName = "Sur Name";
        firstName = "First Name";
        mail = "mail@mail.com";
        location = "Paris";
        description = "Description";
    }
}
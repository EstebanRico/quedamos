package com.sngt.taxis.stargui.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by skiss on 05/10/2015.
 */
@Entity
public class Mail {

    @Id
    @GeneratedValue
    public Integer mailId;

    public String dateCreation;

    public Integer getMailId() {
        return mailId;
    }

    public void setMailId(Integer mailId) {
        this.mailId = mailId;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getHeureCreation() {
        return heureCreation;
    }

    public void setHeureCreation(String heureCreation) {
        this.heureCreation = heureCreation;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getLu() {
        return lu;
    }

    public void setLu(Boolean lu) {
        this.lu = lu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String heureCreation;

    public String msg;
    public Boolean lu;

    @OneToOne
    public User user; //Un mail est écrit que par un seul utilisateur.

}

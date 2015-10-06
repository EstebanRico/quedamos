package com.sngt.taxis.stargui.web.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

/**
 * Created by skiss on 05/10/2015.
 */
@Entity
public class Discussion {

    @Id
    @GeneratedValue
    public Integer discId;
    public String dateCreation;
    public String heureCreation;
    public String sujet;

    @OneToMany
    public List<Mail> listeMail;

    @ManyToMany(mappedBy = "listeDiscussion")
    public List<User> listeUser;

    public Discussion(String sujetDisc, String msgMail, User user) {

        Calendar curr = Calendar.getInstance();
        dateCreation = "" + curr.get(Calendar.YEAR) + "-" + curr.get(Calendar.MONTH) + "-" + curr.get(Calendar.DAY_OF_MONTH);
        heureCreation = "" + curr.get(Calendar.HOUR) + ":" + curr.get(Calendar.MINUTE);

        sujet = sujetDisc;

/*
        Mail mail = new Mail(msgMail,user,dateCreation,heureCreation);

        listeMail.add(mail);
*/
    }

    public List<User> getListeUser() {
        return listeUser;
    }

    public void setListeUser(List<User> listeUser) {
        this.listeUser = listeUser;
    }

    public Integer getDiscId() {
        return discId;
    }

    public void setDiscId(Integer discId) {
        this.discId = discId;
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

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public List<Mail> getListeMail() {
        return listeMail;
    }

    public void setListeMail(List<Mail> listeMail) {
        this.listeMail = listeMail;
    }

    public void addMail(Mail mail) {
        listeMail.add(mail);
    }
}

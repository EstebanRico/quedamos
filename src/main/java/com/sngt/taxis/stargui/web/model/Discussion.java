package com.sngt.taxis.stargui.web.model;

import javax.persistence.*;
import java.util.ArrayList;
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

    public Discussion() {
        super();
        Calendar curr = Calendar.getInstance();
        dateCreation = "" + curr.get(Calendar.YEAR) + "-" + curr.get(Calendar.MONTH) + "-" + curr.get(Calendar.DAY_OF_MONTH);
        heureCreation = "" + curr.get(Calendar.HOUR) + ":" + curr.get(Calendar.MINUTE);
    }

    public Discussion(Mail mail, User user) {
        this();

        listeMail = new ArrayList<Mail>();
        listeMail.add(mail);

    }

    public Discussion(String sujetDisc, Mail mail, User user1, User user2) {

        this(mail,user1);

        sujet = sujetDisc;

        listeMail = new ArrayList<Mail>();
        listeMail.add(mail);

        listeUser = new ArrayList<User>();
        listeUser.add(user1);
        listeUser.add(user2);

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

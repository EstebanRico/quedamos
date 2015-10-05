package com.sngt.taxis.stargui.web.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by skiss on 05/10/2015.
 */
@Entity
public class Discussion {

    @Id
    @GeneratedValue
    public Integer discId;

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

    public String dateCreation;
    public String heureCreation;
    public String sujet;

    @OneToMany
    public List<Mail> listeMail;


}

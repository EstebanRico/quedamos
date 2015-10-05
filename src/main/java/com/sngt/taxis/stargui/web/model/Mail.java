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
    public String heureCreation;

    public String msg;
    public Boolean lu;

    @OneToOne
    public User user;

}

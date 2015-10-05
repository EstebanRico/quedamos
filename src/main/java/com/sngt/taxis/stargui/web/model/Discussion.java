package com.sngt.taxis.stargui.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    public String typeDiscussion; /*E:Event et M:Member*/
    public String sujet;

    @OneToMany
    public List<Mail> listeMail;


}

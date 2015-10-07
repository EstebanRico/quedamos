package com.sngt.taxis.stargui.web.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by skiss on 11/09/2015.
 */
@Entity
public class Event {

    @Id
    @GeneratedValue
    public Integer eventId;
    public Integer userId;
    public String dateCreation;
    public String description;
    public Integer nbPlaces;
    public String telephone;
    public String name;
    public String type;
    public String dateRDV;
    public String heureRDV;
    public String location;

    @OneToMany
    public List<User> listUserEnroll;

    @OneToOne
    public Discussion discussion;

    public Discussion getDiscussion() {
        return discussion;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }


    public List<User> getListUserEnroll() {
        return listUserEnroll;
    }

    public void setListUserEnroll(List<User> listUserEnroll) {
        this.listUserEnroll = listUserEnroll;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(Integer nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateRDV() {
        return dateRDV;
    }

    public void setDateRDV(String dateRDV) {
        this.dateRDV = dateRDV;
    }

    public String getHeureRDV() {
        return heureRDV;
    }

    public void setHeureRDV(String heureRDV) {
        this.heureRDV = heureRDV;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", userId=" + userId +
                ", dateCreation='" + dateCreation + '\'' +
                ", description='" + description + '\'' +
                ", nbPlaces=" + nbPlaces +
                ", telephone='" + telephone + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", dateRDV='" + dateRDV + '\'' +
                ", heureRDV='" + heureRDV + '\'' +
                ", location='" + location + '\'' +
                '}';
    }


    public void setParticipant(User userIdView) {
        listUserEnroll.add(userIdView);
    }


}

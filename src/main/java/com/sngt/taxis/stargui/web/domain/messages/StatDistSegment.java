package com.sngt.taxis.stargui.web.domain.messages;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class StatDistSegment extends AbstractEntityPart
{
    private static final long serialVersionUID = 1L;
    private Date date;
    @Documentation("Type de segment")
    @JsonProperty("ts")
    private String typeSegment;
    private boolean approximative;
    @Documentation("Dur\u00e9e cumul\u00e9e")
    @JsonProperty("dc")
    private long cumulatedDuration;
    private long approximativeCumulatedDuration;
    @Documentation("Distance cumul\u00e9e")
    @JsonProperty("dsc")
    private float distance;
    private float approximativeCumulatedDistance;
    private double speed;
    @Documentation("Zone g\u00e9ographique")
    @JsonProperty("zg")
    private String zone;
    @Documentation("Cr\u00e9neau horaires")
    @JsonProperty("ph")
    private int plageHoraire;
    @Documentation("Ratio")
    @JsonProperty("rt")
    private long ratio;
    
    public StatDistSegment() {
        this.typeSegment = "U";
    }
    
    public void setDate(final Date date) {
        this.date = date;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public void setApproximative(final boolean approximative) {
        this.approximative = approximative;
    }
    
    public boolean isApproximative() {
        return this.approximative;
    }
    
    public void setCumulatedDuration(final long cumulatedDuration) {
        this.cumulatedDuration = cumulatedDuration;
    }
    
    public long getCumulatedDuration() {
        return this.cumulatedDuration;
    }
    
    public void setApproximativeCumulatedDuration(final long approximativeCumulatedDuration) {
        this.approximativeCumulatedDuration = approximativeCumulatedDuration;
    }
    
    public long getApproximativeCumulatedDuration() {
        return this.approximativeCumulatedDuration;
    }
    
    public String toString() {
        return "StatDistSegment{date=" + this.date + ", approximative=" + this.approximative + ", cumulatedDuration=" + this.cumulatedDuration + ", approximativeCumulatedDuration=" + this.approximativeCumulatedDuration + ", distance=" + this.distance + ", approximativeCumulatedDistance=" + this.approximativeCumulatedDistance + '}';
    }
    
    public void setDistance(final float distance) {
        this.distance = distance;
    }
    
    public float getDistance() {
        return this.distance;
    }
    
    public void setApproximativeCumulatedDistance(final float approximativeCumulatedDistance) {
        this.approximativeCumulatedDistance = approximativeCumulatedDistance;
    }
    
    public float getApproximativeCumulatedDistance() {
        return this.approximativeCumulatedDistance;
    }
    
    public void initEg() {
    }
    
    public void setSpeed(final double speed) {
        this.speed = speed;
    }
    
    public double getSpeed() {
        return this.speed;
    }
    
    public void setZone(final String zone) {
        this.zone = zone;
    }
    
    public String getZone() {
        return this.zone;
    }
    
    public void setPlageHoraire(final int plageHoraire) {
        this.plageHoraire = plageHoraire;
    }
    
    public int getPlageHoraire() {
        return this.plageHoraire;
    }
    
    public void setTypeSegment(final String typeSegment) {
        this.typeSegment = typeSegment;
    }
    
    public String getTypeSegment() {
        return this.typeSegment;
    }
    
    public void setRatio(final long ratio) {
        this.ratio = ratio;
    }
    
    public long getRatio() {
        return this.ratio;
    }
}

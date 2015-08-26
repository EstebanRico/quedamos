package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class StatDistSegmentEntity extends AbstractEntityPart
{
    @Documentation("Type de segment")
    @JsonProperty("ts")
    private String typeSegment;
    @Documentation("Dur\u00e9e cumul\u00e9e")
    @JsonProperty("dc")
    private long cumulatedDuration;
    @Documentation("Distance cumul\u00e9e")
    @JsonProperty("dsc")
    private float distance;
    @Documentation("Zone g\u00e9ographique")
    @JsonProperty("zg")
    private String zone;
    @Documentation("Cr\u00e9neau horaires")
    @JsonProperty("ph")
    private int plageHoraire;
    @Documentation("Ratio")
    @JsonProperty("rt")
    private long ratio;
    
    public StatDistSegmentEntity() {
        this.typeSegment = "U";
    }
    
    public StatDistSegmentEntity(final String typeSegment, final long cumulatedDuration, final float distance, final String zone, final int plageHoraire, final long ratio) {
        this.typeSegment = "U";
        this.typeSegment = typeSegment;
        this.cumulatedDuration = cumulatedDuration;
        this.distance = distance;
        this.zone = zone;
        this.plageHoraire = plageHoraire;
        this.ratio = ratio;
    }
    
    public String toString() {
        return "StatDistSegmentEntity{typeSegment='" + this.typeSegment + '\'' + ", cumulatedDuration=" + this.cumulatedDuration + ", distance=" + this.distance + ", zone='" + this.zone + '\'' + ", plageHoraire=" + this.plageHoraire + ", ratio=" + this.ratio + '}';
    }
    
    public String getTypeSegment() {
        return this.typeSegment;
    }
    
    public void setTypeSegment(final String typeSegment) {
        this.typeSegment = typeSegment;
    }
    
    public long getCumulatedDuration() {
        return this.cumulatedDuration;
    }
    
    public void setCumulatedDuration(final long cumulatedDuration) {
        this.cumulatedDuration = cumulatedDuration;
    }
    
    public float getDistance() {
        return this.distance;
    }
    
    public void setDistance(final float distance) {
        this.distance = distance;
    }
    
    public String getZone() {
        return this.zone;
    }
    
    public void setZone(final String zone) {
        this.zone = zone;
    }
    
    public int getPlageHoraire() {
        return this.plageHoraire;
    }
    
    public void setPlageHoraire(final int plageHoraire) {
        this.plageHoraire = plageHoraire;
    }
    
    public long getRatio() {
        return this.ratio;
    }
    
    public void setRatio(final long ratio) {
        this.ratio = ratio;
    }
    
    public void initEg() {
    }
}

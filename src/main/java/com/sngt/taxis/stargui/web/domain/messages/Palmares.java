package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class Palmares extends AbstractEntityPart
{
    @Documentation("Num\u00e9ro de zone")
    @JsonProperty("an")
    private int mZone;
    @Documentation("Nombre de courses")
    @JsonProperty("jn")
    private int mJourneyNumber;
    @Documentation("Nombre de taxis")
    @JsonProperty("tn")
    private int mTaxis;
    @Documentation("Niveau")
    @JsonProperty("ni")
    private int mNiveau;
    
    public void initEg() {
    }
    
    public int getZone() {
        return this.mZone;
    }
    
    public void setZone(final int zone) {
        this.mZone = zone;
    }
    
    public int getJourneyNumber() {
        return this.mJourneyNumber;
    }
    
    public void setJourneyNumber(final int journeyNumber) {
        this.mJourneyNumber = journeyNumber;
    }
    
    public int getTaxis() {
        return this.mTaxis;
    }
    
    public void setTaxis(final int taxis) {
        this.mTaxis = taxis;
    }
    
    public int getNiveau() {
        return this.mNiveau;
    }
    
    public void setNiveau(final int niveau) {
        this.mNiveau = niveau;
    }
    
    public String toString() {
        return "[mZone=" + this.mZone + ", mJourneyNumber=" + this.mJourneyNumber + ", mTaxis=" + this.mTaxis + ", mNiveau=" + this.mNiveau + "]";
    }
}

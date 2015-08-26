package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public abstract class AbstractEntityWithCommonPart extends AbstractEntity
{
    private static final long serialVersionUID = -3559773309223583177L;
    @JsonProperty("loc")
    @Documentation("Position")
    private Geolocation mLocation;
    @JsonProperty("t")
    @Documentation("Etat du taxim\u00e8tre")
    private char mTaximeterState;
    @JsonProperty("s")
    @Documentation(value = "Heure de g\u00e9n\u00e9ration du message", comment = "en secondes depuis minuit")
    private Integer mTime;
    
    public AbstractEntityWithCommonPart(final String messageType) {
        super(messageType);
    }
    
    public AbstractEntityWithCommonPart(final String messageType, final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(messageType);
        this.mLocation = geolocation;
        this.mTaximeterState = taximeterState;
        this.mTime = time;
    }
    
    public Geolocation getLocation() {
        return this.mLocation;
    }
    
    public void setLocation(final Geolocation location) {
        this.mLocation = location;
    }
    
    public char getTaximeterState() {
        return this.mTaximeterState;
    }
    
    public void setTaximeterState(final char taximeterState) {
        this.mTaximeterState = taximeterState;
    }
    
    public Integer getTime() {
        return this.mTime;
    }
    
    public void setTime(final Integer time) {
        this.mTime = time;
    }
    
    public void initEg() {
        (this.mLocation = new Geolocation()).initEg();
        this.mTaximeterState = '\0';
        this.mTime = 1000;
    }
    
    public String toString() {
        return " [" + this.mLocation + ", mTaximeterState=" + this.mTaximeterState + ", mTime=" + this.mTime + " secondes]";
    }
}

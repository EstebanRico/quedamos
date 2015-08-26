package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class Geolocation extends AbstractEntityPart
{
    @JsonProperty("L")
    @Documentation("latitude")
    private Double mLatitude;
    @JsonProperty("l")
    @Documentation("longitude")
    private Double mLongitude;
    @JsonProperty("d")
    @Documentation(value = "date du fix", comment = "en secondes depuis minuit")
    private Integer mDate;
    
    public Geolocation(final Double latitude, final Double longitude, final Integer date) {
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mDate = date;
    }
    
    public Geolocation() {
    }
    
    public Double getLatitude() {
        return this.mLatitude;
    }
    
    public void setLatitude(final Double latitude) {
        this.mLatitude = latitude;
    }
    
    public Double getLongitude() {
        return this.mLongitude;
    }
    
    public void setLongitude(final Double longitude) {
        this.mLongitude = longitude;
    }
    
    public Integer getDate() {
        return this.mDate;
    }
    
    public void setDate(final Integer date) {
        this.mDate = date;
    }
    
    public void initEg() {
        this.mLatitude = 0.0;
        this.mLongitude = 1.0;
        this.mDate = 1111;
    }
    
    public String toString() {
        return "Geolocation [mLatitude=" + this.mLatitude + ", mLongitude=" + this.mLongitude + ", mDate=" + this.mDate + "]";
    }
}

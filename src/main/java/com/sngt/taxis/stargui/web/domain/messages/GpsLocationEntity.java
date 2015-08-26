package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GpsLocationEntity
{
    @JsonProperty("L")
    private Double mLatitude;
    @JsonProperty("l")
    private Double mLongitude;
    @JsonProperty("d")
    private String mDate;
    @JsonIgnore
    private float mAccuracy;
    
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
    
    public String getDate() {
        return this.mDate;
    }
    
    public void setDate(final String date) {
        this.mDate = date;
    }
    
    public float getAccuracy() {
        return this.mAccuracy;
    }
    
    public void setAccuracy(final float mAccuracy) {
        this.mAccuracy = mAccuracy;
    }
    
    @Override
    public String toString() {
        return "   {latitude=" + this.mLatitude + ", longitude=" + this.mLongitude + ", date='" + this.mDate + '\'' + ", accuracy=" + this.mAccuracy + '}';
    }
}

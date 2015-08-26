package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class Booking extends AbstractEntityPart
{
    @Documentation("Num\u00e9ro de zone")
    @JsonProperty("an")
    private int mZone;
    @Documentation("R\u00e9servations")
    @JsonProperty("rn")
    private int mReservationsNumber;
    @Documentation("Taxis number")
    @JsonProperty("tn")
    private int mTaxis;
    
    public void initEg() {
    }
    
    public int getZone() {
        return this.mZone;
    }
    
    public void setZone(final int zone) {
        this.mZone = zone;
    }
    
    public int getReservationsNumber() {
        return this.mReservationsNumber;
    }
    
    public void setReservationsNumber(final int reservationsNumber) {
        this.mReservationsNumber = reservationsNumber;
    }
    
    public int getTaxis() {
        return this.mTaxis;
    }
    
    public void setTaxis(final int taxis) {
        this.mTaxis = taxis;
    }
    
    public String toString() {
        return "Booking [mZone=" + this.mZone + ", mReservationsNumber=" + this.mReservationsNumber + ", mTaxis=" + this.mTaxis + "]";
    }
}

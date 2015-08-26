package com.sngt.taxis.stargui.web.domain.messages;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class StatusDispEntity extends AbstractEntity
{
    private static final long serialVersionUID = -8119649785405810419L;
    @Documentation("Zone")
    @JsonProperty("an")
    private Integer mZoneNumber;
    @Documentation("rang")
    @JsonProperty("rpf")
    private Integer mRangPrimaryFleet;
    @Documentation("nb_resas")
    @JsonProperty("nrpf")
    private Integer mNbResaPrimaryFleet;
    @Documentation("rang toute flotte")
    @JsonProperty("raf")
    private Integer mRangAllFleet;
    @Documentation("nb_resas toute flotte")
    @JsonProperty("nraf")
    private Integer mNbResaAllFleet;
    @JsonIgnore
    private Date mDate;
    
    public StatusDispEntity() {
        super(MQMessageType.STATUS_DISP.getType());
    }
    
    public Date getDate() {
        return this.mDate;
    }
    
    public void setDate(final Date date) {
        this.mDate = date;
    }
    
    public Integer getZoneNumber() {
        return this.mZoneNumber;
    }
    
    public void setZoneNumber(final Integer zoneNumber) {
        this.mZoneNumber = zoneNumber;
    }
    
    public Integer getRangPrimaryFleet() {
        return this.mRangPrimaryFleet;
    }
    
    public void setRangPrimaryFleet(final Integer rangPrimaryFleet) {
        this.mRangPrimaryFleet = rangPrimaryFleet;
    }
    
    public Integer getNbResaPrimaryFleet() {
        return this.mNbResaPrimaryFleet;
    }
    
    public void setNbResaPrimaryFleet(final Integer nbResaPrimaryFleet) {
        this.mNbResaPrimaryFleet = nbResaPrimaryFleet;
    }
    
    public Integer getRangAllFleet() {
        return this.mRangAllFleet;
    }
    
    public void setRangAllFleet(final Integer rangAllFleet) {
        this.mRangAllFleet = rangAllFleet;
    }
    
    public Integer getNbResaAllFleet() {
        return this.mNbResaAllFleet;
    }
    
    public void setNbResaAllFleet(final Integer nbResaAllFleet) {
        this.mNbResaAllFleet = nbResaAllFleet;
    }
    
    public String toString() {
        return " {mZoneNumber=" + this.mZoneNumber + ", mRangPrimaryFleet=" + this.mRangPrimaryFleet + ", mNbResaPrimaryFleet=" + this.mNbResaPrimaryFleet + ", mRangAllFleet=" + this.mRangAllFleet + ", mNbResaAllFleet=" + this.mNbResaAllFleet + ", date=" + this.mDate + '}';
    }
    
    public void initEg() {
        this.mZoneNumber = 22;
        this.mRangPrimaryFleet = 12;
        this.mNbResaPrimaryFleet = 3;
        this.mRangAllFleet = 13;
        this.mNbResaAllFleet = 4;
    }
}

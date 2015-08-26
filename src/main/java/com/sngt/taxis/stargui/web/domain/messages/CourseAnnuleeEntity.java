package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class CourseAnnuleeEntity extends AbstractEntity
{
    private static final long serialVersionUID = 1L;
    @Documentation("Numero Course")
    @JsonProperty("i")
    private String mFareId;
    @Documentation("info compl\u00e9mentaire chauffeur")
    @JsonProperty("di")
    private String mDriverInfos;
    @Documentation(" indicateur Paiement en relev\u00e9")
    @JsonProperty("rlv")
    private boolean mIndicator;
    @Documentation("Suite \u00e0 non charge")
    @JsonProperty("rnl")
    private boolean mRestNoLoad;
    
    public void initEg() {
        this.mDriverInfos = "info compl\u00e9mentaire chauffeur";
        this.mIndicator = true;
    }
    
    public CourseAnnuleeEntity() {
        super(MQMessageType.COURSE_ANNULEE.getType());
    }
    
    public void setFareId(final String fareId) {
        this.mFareId = fareId;
    }
    
    public void setDriverInfos(final String driverInfos) {
        this.mDriverInfos = driverInfos;
    }
    
    public void setRestNoLoad(final boolean restNoLoad) {
        this.mRestNoLoad = restNoLoad;
    }
    
    public void setIndicator(final boolean indicator) {
        this.mIndicator = indicator;
    }
    
    public String toString() {
        return "[numero de course=" + this.mFareId + ",  info complementaire chauffeur=" + this.mDriverInfos + ", indicateur=" + this.mIndicator + ",non charge=" + this.mRestNoLoad + "]";
    }
}

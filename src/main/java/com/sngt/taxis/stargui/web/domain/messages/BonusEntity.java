package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class BonusEntity extends AbstractEntity
{
    private static final long serialVersionUID = -8117092749675611085L;
    @Documentation("Expiration")
    @JsonProperty("d")
    public String mDate;
    @Documentation("Points")
    @JsonProperty("nbp")
    public String mNumberPoints;
    
    public void initEg() {
        this.mNumberPoints = "4";
        this.mDate = "dd/mm/aaaa";
    }
    
    public BonusEntity() {
        super(MQMessageType.BONUS.getType());
    }
    
    public String getDate() {
        return this.mDate;
    }
    
    public void setDate(final String date) {
        this.mDate = date;
    }
    
    public String getNumberPoints() {
        return this.mNumberPoints;
    }
    
    public void setNumberPoints(final String numberPoints) {
        this.mNumberPoints = numberPoints;
    }
    
    public String toString() {
        return " [mDate=" + this.mDate + ", mNumberPoints=" + this.mNumberPoints + "]";
    }
}

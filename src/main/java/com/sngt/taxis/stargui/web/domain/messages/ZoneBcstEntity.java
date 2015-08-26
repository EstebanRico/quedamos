package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

public class ZoneBcstEntity extends AbstractEntity
{
    @Documentation("Type de r\u00e9sa")
    @JsonProperty("bt")
    private int mBookingType;
    @Documentation("Liste de r\u00e9sas")
    @JsonProperty("bl")
    private List<Booking> mBookingList;
    
    public ZoneBcstEntity() {
        super(MQMessageType.ZONE_BCST.getType());
        this.mBookingList = new ArrayList<Booking>();
    }
    
    public void initEg() {
    }
    
    public int getBookingType() {
        return this.mBookingType;
    }
    
    public void setBookingType(final int bookingType) {
        this.mBookingType = bookingType;
    }
    
    public List<Booking> getBookingList() {
        return this.mBookingList;
    }
    
    public String toString() {
        return " [mBookingType=" + this.mBookingType + ", mBookingList=" + this.mBookingList + "]";
    }
}

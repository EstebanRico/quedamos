package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

public class StatDistEntity extends AbstractEntity
{
    @Documentation("Version")
    @JsonProperty("v")
    private String version;
    @Documentation("Num\u00e9ro de course")
    @JsonProperty("fi")
    private int fareId;
    @Documentation("Code chauffeur")
    @JsonProperty("cc")
    private int codeChauffeur;
    @Documentation("Date du meter on")
    @JsonProperty("dmo")
    private String meterOnDate;
    @Documentation("Heure du meter on")
    @JsonProperty("hmo")
    private String meterOnHour;
    @Documentation("Distance totale de la course")
    @JsonProperty("dt")
    private float totalDistance;
    @Documentation("Segments")
    @JsonProperty("s")
    private List<StatDistSegmentEntity> segments;
    
    public StatDistEntity() {
        super(MQMessageType.STAT_DIST.getType());
    }
    
    public StatDistEntity(final String version, final int codeChauffeur, final Date meterOnDate, final float totalDistance, final List<StatDistSegmentEntity> segments) {
        super(MQMessageType.STAT_DIST.getType());
        this.version = version;
        this.codeChauffeur = codeChauffeur;
        this.meterOnDate = ((meterOnDate != null) ? DateUtils.formatDateStatDistDateFormat(meterOnDate) : "");
        this.meterOnHour = ((meterOnDate != null) ? DateUtils.formatDateStatDistHourFormat(meterOnDate) : "");
        this.totalDistance = totalDistance;
        this.segments = segments;
    }
    
    public void initEg() {
    }
    
    public void setFareId(final int fareId) {
        this.fareId = fareId;
    }
    
    public String toString() {
        return "StatDistEntity{version='" + this.version + '\'' + ", fareId=" + this.fareId + ", codeChauffeur=" + this.codeChauffeur + ", meterOnDate='" + this.meterOnDate + '\'' + ", meterOnHour='" + this.meterOnHour + '\'' + ", totalDistance=" + this.totalDistance + ", segments=" + this.segments + '}';
    }
}

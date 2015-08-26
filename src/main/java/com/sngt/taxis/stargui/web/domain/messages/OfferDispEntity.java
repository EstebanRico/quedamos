package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

public class OfferDispEntity extends AbstractEntity
{
    private static final long serialVersionUID = -9186404990516575413L;
    @Documentation("Numero Course")
    @JsonProperty("i")
    private String mFareId;
    @Documentation("Zone")
    @JsonProperty("an")
    private String mAreaNumber;
    @Documentation("Type de Voie")
    @JsonProperty("st")
    private String mStreetType;
    @Documentation("Nom de voie")
    @JsonProperty("sn")
    private String mStreetName;
    @Documentation("Ville")
    @JsonProperty("c")
    private String mCity;
    @Documentation("Distance")
    @JsonProperty("d")
    private String mDistance;
    @Documentation("Type de client")
    @JsonProperty("ct")
    private String mCustomerType;
    @Documentation("Attributs")
    @JsonProperty("ats")
    private List<String> mAttributes;
    @Documentation("D\u00e9lai d'approche")
    @JsonProperty("tg")
    private Integer mTimeToGo;
    @Documentation("Heure de RV")
    @JsonProperty("mh")
    private String mMeetingHour;
    @Documentation("Delai demand\u00e9")
    @JsonProperty("rp")
    private boolean mRequestedPeriod;
    @Documentation("Commentaires")
    @JsonProperty("cmt")
    private String mComments;
    @Documentation("Refus")
    @JsonProperty("rf")
    private boolean mRefusal;
    @Documentation("Priotaire")
    @JsonProperty("pr")
    private boolean mPriority;
    @Documentation("Latitude client")
    @JsonProperty("lat")
    private Double mClientLatitude;
    @Documentation("Longitude client")
    @JsonProperty("lon")
    private Double mClientLongitude;
    @Documentation("Indicateur de course wecab")
    @JsonProperty("wc")
    private boolean mWeCab;
    
    public OfferDispEntity() {
        super(MQMessageType.OFFER_DISP.getType());
        this.mAttributes = new ArrayList<String>();
    }
    
    public OfferDispEntity(final String type) {
        super(type);
        this.mAttributes = new ArrayList<String>();
    }
    
    public String getFareId() {
        return this.mFareId;
    }
    
    public void setFareId(final String fareId) {
        this.mFareId = fareId;
    }
    
    public String getAreaNumber() {
        return this.mAreaNumber;
    }
    
    public void setAreaNumber(final String areaNumber) {
        this.mAreaNumber = areaNumber;
    }
    
    public String getStreetType() {
        return this.mStreetType;
    }
    
    public void setStreetType(final String streetType) {
        this.mStreetType = streetType;
    }
    
    public String getStreetName() {
        return this.mStreetName;
    }
    
    public void setStreetName(final String streetName) {
        this.mStreetName = streetName;
    }
    
    public String getDistance() {
        return this.mDistance;
    }
    
    public void setDistance(final String distance) {
        this.mDistance = distance;
    }
    
    public String getCustomerType() {
        return this.mCustomerType;
    }
    
    public void setCustomerType(final String customerType) {
        this.mCustomerType = customerType;
    }
    
    public List<String> getAttributes() {
        return this.mAttributes;
    }
    
    public void setAttributes(final List<String> attributes) {
        this.mAttributes = attributes;
    }
    
    public Integer getTimeToGo() {
        return this.mTimeToGo;
    }
    
    public void setTimeToGo(final Integer timeToGo) {
        this.mTimeToGo = timeToGo;
    }
    
    public String getCity() {
        return this.mCity;
    }
    
    public void setCity(final String city) {
        this.mCity = city;
    }
    
    public String getComments() {
        return this.mComments;
    }
    
    public void setComments(final String comments) {
        this.mComments = comments;
    }
    
    public boolean isRefusal() {
        return this.mRefusal;
    }
    
    public void setRefusal(final boolean refusal) {
        this.mRefusal = refusal;
    }
    
    public boolean isPriority() {
        return this.mPriority;
    }
    
    public void setPriority(final boolean priority) {
        this.mPriority = priority;
    }
    
    public String getMeetingHour() {
        return this.mMeetingHour;
    }
    
    public void setMeetingHour(final String meetingHour) {
        this.mMeetingHour = meetingHour;
    }
    
    public boolean getRequestedPeriod() {
        return this.mRequestedPeriod;
    }
    
    public void setRequestedPeriod(final boolean requestedPeriod) {
        this.mRequestedPeriod = requestedPeriod;
    }
    
    public Double getClientLatitude() {
        return this.mClientLatitude;
    }
    
    public void setClientLatitude(final Double clientLatitude) {
        this.mClientLatitude = clientLatitude;
    }
    
    public Double getClientLongitude() {
        return this.mClientLongitude;
    }
    
    public void setClientLongitude(final Double clientLongitude) {
        this.mClientLongitude = clientLongitude;
    }
    
    public boolean isWeCab() {
        return this.mWeCab;
    }
    
    public void setWeCab(final boolean weCab) {
        this.mWeCab = weCab;
    }
    
    public String toString() {
        return " {mFareId=" + this.mFareId + ", mAreaNumber=" + this.mAreaNumber + ", mStreetType='" + this.mStreetType + '\'' + ", mStreetName='" + this.mStreetName + '\'' + ", mCity='" + this.mCity + '\'' + ",mClientLatitude=" + this.mClientLatitude + '\'' + ",mClientLongitude=" + this.mClientLongitude + '\'' + ", mDistance=" + this.mDistance + ", mCustomerType='" + this.mCustomerType + '\'' + ", mWeCab='" + this.mWeCab + '\'' + ", mAttributes=" + this.mAttributes + ", mTimeToGo=" + this.mTimeToGo + ",delai demand\u00e9 :" + this.mRequestedPeriod + ",Heure de rendez-vous :" + this.mMeetingHour + ", mMeetingHour='" + this.mMeetingHour + '\'' + ", mRequestedPeriod=" + this.mRequestedPeriod + ", mComments='" + this.mComments + '\'' + ", mRefusal=" + this.mRefusal + ", mPriority=" + this.mPriority + '}';
    }
    
    public void initEg() {
        this.mFareId = "1223";
        this.mAreaNumber = "12";
        this.mStreetType = "Rue";
        this.mStreetName = "Claude Tllier";
        this.mCity = "Paris";
        this.mClientLatitude = 48.839606;
        this.mClientLongitude = 2.336692;
        this.mDistance = "12.3d";
        this.mCustomerType = "Professionnel";
        this.mAttributes = Arrays.asList("FOO", "BAR");
        this.mTimeToGo = 12;
        this.mMeetingHour = "HH:MM";
        this.mRequestedPeriod = true;
        this.mComments = "CECI est un commentaire";
        this.mRefusal = false;
        this.mPriority = true;
    }
}

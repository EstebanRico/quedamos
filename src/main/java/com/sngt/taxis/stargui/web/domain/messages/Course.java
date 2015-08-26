package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

public class Course extends AbstractEntityPart
{
    @Documentation("Nombre de passagers")
    @JsonProperty("nbp")
    private Integer mNbPassenger;
    @Documentation("Nombre de bagages")
    @JsonProperty("nbb")
    private Integer mNbLuggage;
    @Documentation("Adresse de destination")
    @JsonProperty("da")
    private String mDestAddress;
    @Documentation("Point de rencontre")
    @JsonProperty("mp")
    private String mMeetingPoint;
    @Documentation("Heure de RDV")
    @JsonProperty("mh")
    private String mMeetingHour;
    @Documentation("Commentaire adresse")
    @JsonProperty("addrc")
    private String mAddressComment;
    @Documentation("Type de client")
    @JsonProperty("ct")
    private String mCustomerType;
    @Documentation("R\u00e9f\u00e9rence passager")
    @JsonProperty("pr")
    private String mPassengerRef;
    @Documentation(value = "Nom de client", comment = "Soci\u00e9t\u00e9")
    @JsonProperty("cn")
    private String mCustomerName;
    @Documentation("Commentaire client")
    @JsonProperty("cc")
    private String mCustomerComment;
    @Documentation("Commentaire attente")
    @JsonProperty("wc")
    private String mWaitingComment;
    @Documentation("Commentaire autorise")
    @JsonProperty("ac")
    private String mAuthorizedComment;
    @Documentation("Commentaire libre")
    @JsonProperty("fc")
    private String mFreeComment;
    @Documentation("Nombre de taxis command\u00e9s")
    @JsonProperty("ot")
    private Integer mOrderedTaxis;
    @Documentation("Approche")
    @JsonProperty("tp")
    private String mTimePeriod;
    @Documentation("Destinations")
    @JsonProperty("dl")
    private List<String> mDestinationList;
    @Documentation("D\u00e9poses")
    @JsonProperty("ll")
    private List<String> mLeftList;
    @Documentation("Nom du passager")
    @JsonProperty("p")
    private String mPassengerName;
    @Documentation("Ville")
    @JsonProperty("c")
    private String mCity;
    @Documentation("Numero de voie")
    @JsonProperty("n")
    private String mStreetNumber;
    @Documentation("type de voie")
    @JsonProperty("st")
    private String mStreetType;
    @Documentation("Nom de voie")
    @JsonProperty("sn")
    private String mStreetName;
    @Documentation("Pr\u00e9cisions adresse")
    @JsonProperty("pa")
    private String mPreciseAddress;
    @Documentation("Num\u00e9ro du plan")
    @JsonProperty("map")
    private Integer mMapNumber;
    @Documentation("Num\u00e9ro de vol/train")
    @JsonProperty("nf")
    private String mFlightNumber;
    @Documentation("D\u00e9lai Demand\u00e9")
    @JsonProperty("rp")
    private Boolean mRequestedPeriod;
    @Documentation("Latitude client")
    @JsonProperty("lat")
    private Double mClientLatitude;
    @Documentation("Longitude client")
    @JsonProperty("lon")
    private Double mClientLongitude;
    
    public void initEg() {
        this.mPassengerName = "DUPONT";
        this.mCity = "Paris";
        this.mStreetNumber = "12bis";
        this.mStreetType = "Rue";
        this.mStreetName = "Claude Tillier";
        this.mPreciseAddress = "Escalier Nord";
        this.mMapNumber = 2;
        this.mFlightNumber = "AF2333";
        this.mCustomerType = "Abonn\u00e9";
        this.mCustomerName = "ACCOR";
        this.mWaitingComment = "Impatient";
        this.mAuthorizedComment = "??";
        this.mCustomerComment = "Attente longue";
        this.mFreeComment = "RAS";
        this.mOrderedTaxis = 34;
        this.mDestinationList = Arrays.asList("Nation", "R\u00e9publique", "Maillot");
        this.mLeftList = Arrays.asList("Nation", "R\u00e9publique");
        this.mMeetingPoint = "Infos voyageurs";
        this.mMeetingHour = "12H00";
        this.mTimePeriod = "34 min";
        this.mRequestedPeriod = false;
        this.mNbPassenger = 2;
        this.mNbLuggage = 1;
        this.mDestAddress = "A\u00e9roport CDG";
        this.mAddressComment = "Commentaire";
        this.mPassengerRef = "AB123";
        this.mClientLatitude = 48.20123;
        this.mClientLongitude = 2.312456;
    }
    
    public Integer getNbPassenger() {
        return this.mNbPassenger;
    }
    
    public void setNbPassenger(final Integer nbPassenger) {
        this.mNbPassenger = nbPassenger;
    }
    
    public Integer getNbLuggage() {
        return this.mNbLuggage;
    }
    
    public void setNbLuggage(final Integer nbLuggage) {
        this.mNbLuggage = nbLuggage;
    }
    
    public String getDestAddress() {
        return this.mDestAddress;
    }
    
    public void setDestAddress(final String destAddress) {
        this.mDestAddress = destAddress;
    }
    
    public String getMeetingPoint() {
        return this.mMeetingPoint;
    }
    
    public void setMeetingPoint(final String meetingPoint) {
        this.mMeetingPoint = meetingPoint;
    }
    
    public String getMeetingHour() {
        return this.mMeetingHour;
    }
    
    public void setMeetingHour(final String meetingHour) {
        this.mMeetingHour = meetingHour;
    }
    
    public String getAddressComment() {
        return this.mAddressComment;
    }
    
    public void setAddressComment(final String addressComment) {
        this.mAddressComment = addressComment;
    }
    
    public String getCustomerType() {
        return this.mCustomerType;
    }
    
    public void setCustomerType(final String customerType) {
        this.mCustomerType = customerType;
    }
    
    public String getPassengerRef() {
        return this.mPassengerRef;
    }
    
    public void setPassengerRef(final String passengerRef) {
        this.mPassengerRef = passengerRef;
    }
    
    public String getCustomerName() {
        return this.mCustomerName;
    }
    
    public void setCustomerName(final String customerName) {
        this.mCustomerName = customerName;
    }
    
    public String getCustomerComment() {
        return this.mCustomerComment;
    }
    
    public void setCustomerComment(final String customerComment) {
        this.mCustomerComment = customerComment;
    }
    
    public String getWaitingComment() {
        return this.mWaitingComment;
    }
    
    public void setWaitingComment(final String waitingComment) {
        this.mWaitingComment = waitingComment;
    }
    
    public String getAuthorizedComment() {
        return this.mAuthorizedComment;
    }
    
    public void setAuthorizedComment(final String authorizedComment) {
        this.mAuthorizedComment = authorizedComment;
    }
    
    public String getFreeComment() {
        return this.mFreeComment;
    }
    
    public void setFreeComment(final String freeComment) {
        this.mFreeComment = freeComment;
    }
    
    public Integer getOrderedTaxis() {
        return this.mOrderedTaxis;
    }
    
    public void setOrderedTaxis(final Integer orderedTaxis) {
        this.mOrderedTaxis = orderedTaxis;
    }
    
    public String getTimePeriod() {
        return this.mTimePeriod;
    }
    
    public void setTimePeriod(final String timePeriod) {
        this.mTimePeriod = timePeriod;
    }
    
    public List<String> getDestinationList() {
        if (this.mDestinationList == null) {
            this.mDestinationList = new ArrayList();
        }
        return (List<String>)this.mDestinationList;
    }
    
    public void setDestinationList(final List<String> destinationList) {
        this.mDestinationList = destinationList;
    }
    
    public List<String> getLeftList() {
        if (this.mLeftList == null) {
            this.mLeftList = new ArrayList();
        }
        return (List<String>)this.mLeftList;
    }
    
    public void setLeftList(final List<String> leftList) {
        this.mLeftList = leftList;
    }
    
    public String getPassengerName() {
        return this.mPassengerName;
    }
    
    public void setPassengerName(final String passengerName) {
        this.mPassengerName = passengerName;
    }
    
    public String getCity() {
        return this.mCity;
    }
    
    public void setCity(final String city) {
        this.mCity = city;
    }
    
    public String getStreetNumber() {
        return this.mStreetNumber;
    }
    
    public void setStreetNumber(final String streetNumber) {
        this.mStreetNumber = streetNumber;
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
    
    public String getPreciseAddress() {
        return this.mPreciseAddress;
    }
    
    public void setPreciseAddress(final String preciseAddress) {
        this.mPreciseAddress = preciseAddress;
    }
    
    public Integer getMapNumber() {
        return this.mMapNumber;
    }
    
    public void setMapNumber(final Integer mapNumber) {
        this.mMapNumber = mapNumber;
    }
    
    public String getFlightNumber() {
        return this.mFlightNumber;
    }
    
    public void setFlightNumber(final String flightNumber) {
        this.mFlightNumber = flightNumber;
    }
    
    public Boolean getRequestedPeriod() {
        return this.mRequestedPeriod;
    }
    
    public void setRequestedPeriod(final Boolean requestedPeriod) {
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
    
    public String toString() {
        return "{mNbPassenger=" + this.mNbPassenger + ", mNbLuggage=" + this.mNbLuggage + ", mDestAddress='" + this.mDestAddress + '\'' + ", mMeetingPoint='" + this.mMeetingPoint + '\'' + ", mMeetingHour='" + this.mMeetingHour + '\'' + ", mAddressComment='" + this.mAddressComment + '\'' + ", mCustomerType='" + this.mCustomerType + '\'' + ", mPassengerRef='" + this.mPassengerRef + '\'' + ", mCustomerName='" + this.mCustomerName + '\'' + ", mCustomerComment='" + this.mCustomerComment + '\'' + ", mWaitingComment='" + this.mWaitingComment + '\'' + ", mAuthorizedComment='" + this.mAuthorizedComment + '\'' + ", mFreeComment='" + this.mFreeComment + '\'' + ", mOrderedTaxis=" + this.mOrderedTaxis + ", mTimePeriod='" + this.mTimePeriod + '\'' + ", mDestinationList=" + this.mDestinationList + ", mLeftList=" + this.mLeftList + ", mPassengerName='" + this.mPassengerName + '\'' + ", mCity='" + this.mCity + '\'' + ", mStreetNumber='" + this.mStreetNumber + '\'' + ", mStreetType='" + this.mStreetType + '\'' + ", mStreetName='" + this.mStreetName + '\'' + ", mPreciseAddress='" + this.mPreciseAddress + '\'' + ", mMapNumber=" + this.mMapNumber + ", mFlightNumber='" + this.mFlightNumber + '\'' + ", mRequestedPeriod=" + this.mRequestedPeriod + ", mClientLatituder='" + this.mClientLatitude + '\'' + ", mClientLongitude=" + this.mClientLongitude + '}';
    }
}

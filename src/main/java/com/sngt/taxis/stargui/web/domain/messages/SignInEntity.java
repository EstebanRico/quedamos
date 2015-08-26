package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class SignInEntity extends AbstractEntityWithCommonPart
{
    private static final long serialVersionUID = 2033574476850888858L;
    @Documentation("Code radio")
    @JsonProperty("c")
    private Integer mDriverCode;
    @Documentation("Version star")
    @JsonProperty("stv")
    private String mStar2015Version;
    @Documentation("Version Sygic")
    @JsonProperty("syv")
    private String mSygicVersion;
    @Documentation("version SDK sygic")
    @JsonProperty("sydv")
    private String mSygicSdkVersion;
    @Documentation("version de carto")
    @JsonProperty("cv")
    private String mCartoVerison;
    @Documentation("version de TPE")
    @JsonProperty("tpev")
    private String mTPEVersion;
    
    public SignInEntity() {
        super(MQMessageType.SIGN_IN.getType());
    }
    
    public SignInEntity(final Geolocation geolocation, final char taximeterState, final Integer time, final Integer driverCode, final String star2015Version, final String sygicVersion, final String sygicSdkVersion, final String cartoVerison, final String TPEVersion) {
        super(MQMessageType.SIGN_IN.getType(), geolocation, taximeterState, time);
        this.mDriverCode = driverCode;
        this.mStar2015Version = star2015Version;
        this.mSygicVersion = sygicVersion;
        this.mSygicSdkVersion = sygicSdkVersion;
        this.mCartoVerison = cartoVerison;
        this.mTPEVersion = TPEVersion;
    }
    
    public Integer getDriverCode() {
        return this.mDriverCode;
    }
    
    public void setDriverCode(final Integer driverCode) {
        this.mDriverCode = driverCode;
    }
    
    public String getStar2015Version() {
        return this.mStar2015Version;
    }
    
    public void setStar2015Version(final String star2015Version) {
        this.mStar2015Version = star2015Version;
    }
    
    public String getSygicVersion() {
        return this.mSygicVersion;
    }
    
    public void setSygicVersion(final String sygicVersion) {
        this.mSygicVersion = sygicVersion;
    }
    
    public String getSygicSdkVersion() {
        return this.mSygicSdkVersion;
    }
    
    public void setSygicSdkVersion(final String sygicSdkVersion) {
        this.mSygicSdkVersion = sygicSdkVersion;
    }
    
    public String getCartoVerison() {
        return this.mCartoVerison;
    }
    
    public void setCartoVerison(final String cartoVerison) {
        this.mCartoVerison = cartoVerison;
    }
    
    public String getTPEVersion() {
        return this.mTPEVersion;
    }
    
    public void setTPEVersion(final String TPEVersion) {
        this.mTPEVersion = TPEVersion;
    }
    
    public void initEg() {
        super.initEg();
        this.mDriverCode = 1223333;
        this.mStar2015Version = "2015.1";
        this.mSygicVersion = "2.3";
        this.mSygicSdkVersion = "2.22";
        this.mCartoVerison = "122";
        this.mTPEVersion = "0.2";
    }
    
    public String toString() {
        return " [mDriverCode=" + this.mDriverCode + ", mStar2015Version=" + this.mStar2015Version + ", mSygicVersion=" + this.mSygicVersion + ", mSygicSdkVersion=" + this.mSygicSdkVersion + ", mCartoVerison=" + this.mCartoVerison + ", mTPEVersion=" + this.mTPEVersion + "]";
    }
}

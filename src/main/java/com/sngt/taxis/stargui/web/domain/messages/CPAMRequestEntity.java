package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

public class CPAMRequestEntity extends AbstractEntity
{
    @JsonProperty("id")
    private int mRequestId;
    @JsonProperty("pyid")
    private String mPolicyIdentifier;
    @JsonProperty("infd")
    private String mInsuranceFund;
    @JsonProperty("pec")
    private char mPec;
    @JsonProperty("un")
    private String mUserName;
    @JsonProperty("pwd")
    private String mPassword;
    @JsonProperty("dnai")
    private Date mDateNai;
    @JsonProperty("prd")
    private Date mPrescriptionDate;
    @JsonProperty("mat")
    private String mMotifAt;
    @JsonProperty("mald")
    private String mMotifAld;
    @JsonProperty("mcdp")
    private String mMotifCdp100;
    @JsonProperty("ml115")
    private String mModifL115;
    @JsonProperty("datmp")
    private Date mDateAtmp;
    
    public CPAMRequestEntity() {
        super(MQMessageType.CPAM_REQUEST.getType());
    }
    
    public void initEg() {
    }
    
    public int getRequestId() {
        return this.mRequestId;
    }
    
    public void setRequestId(final int requestId) {
        this.mRequestId = requestId;
    }
    
    public String getPolicyIdentifier() {
        return this.mPolicyIdentifier;
    }
    
    public void setPolicyIdentifier(final String policyIdentifier) {
        this.mPolicyIdentifier = policyIdentifier;
    }
    
    public String getInsuranceFund() {
        return this.mInsuranceFund;
    }
    
    public void setInsuranceFund(final String insuranceFund) {
        this.mInsuranceFund = insuranceFund;
    }
    
    public char getPec() {
        return this.mPec;
    }
    
    public void setPec(final char pec) {
        this.mPec = pec;
    }
    
    public String getUserName() {
        return this.mUserName;
    }
    
    public void setUserName(final String userName) {
        this.mUserName = userName;
    }
    
    public String getPassword() {
        return this.mPassword;
    }
    
    public void setPassword(final String password) {
        this.mPassword = password;
    }
    
    public Date getDateNai() {
        return this.mDateNai;
    }
    
    public void setDateNai(final Date dateNai) {
        this.mDateNai = dateNai;
    }
    
    public Date getPrescriptionDate() {
        return this.mPrescriptionDate;
    }
    
    public void setPrescriptionDate(final Date prescriptionDate) {
        this.mPrescriptionDate = prescriptionDate;
    }
    
    public String getMotifAt() {
        return this.mMotifAt;
    }
    
    public void setMotifAt(final String motifAt) {
        this.mMotifAt = motifAt;
    }
    
    public String getMotifAld() {
        return this.mMotifAld;
    }
    
    public void setMotifAld(final String motifAld) {
        this.mMotifAld = motifAld;
    }
    
    public String getMotifCdp100() {
        return this.mMotifCdp100;
    }
    
    public void setMotifCdp100(final String motifCdp100) {
        this.mMotifCdp100 = motifCdp100;
    }
    
    public String getModifL115() {
        return this.mModifL115;
    }
    
    public void setModifL115(final String modifL115) {
        this.mModifL115 = modifL115;
    }
    
    public Date getDateAtmp() {
        return this.mDateAtmp;
    }
    
    public void setDateAtmp(final Date dateAtmp) {
        this.mDateAtmp = dateAtmp;
    }
}

package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class CPAMReplyEntity extends AbstractEntity
{
    @JsonProperty("id")
    private Integer mRequestId;
    @JsonProperty("rr")
    private boolean mRequestResult;
    @JsonProperty("pf")
    private boolean mPaymentFlag;
    @JsonProperty("nbb")
    private Integer mNbBenef;
    @JsonProperty("bnf")
    private String mBenefList;
    @JsonProperty("w1")
    private String mWarning1;
    @JsonProperty("w2")
    private String mWarning2;
    @JsonProperty("pec")
    private String mPec;
    @JsonProperty("in")
    private String mInsuranceNature;
    @JsonProperty("s")
    private String mSituation;
    @JsonProperty("tm")
    private String mModTicket;
    @JsonProperty("pr")
    private Double mPecRatio;
    @JsonProperty("em")
    private String mMessageError;
    
    public CPAMReplyEntity() {
        super(MQMessageType.CPAM_REPLY.getType());
    }
    
    public void initEg() {
    }
    
    public Integer getRequestId() {
        return this.mRequestId;
    }
    
    public void setRequestId(final Integer requestId) {
        this.mRequestId = requestId;
    }
    
    public boolean isRequestResult() {
        return this.mRequestResult;
    }
    
    public void setRequestResult(final boolean requestResult) {
        this.mRequestResult = requestResult;
    }
    
    public boolean isPaymentFlag() {
        return this.mPaymentFlag;
    }
    
    public void setPaymentFlag(final boolean paymentFlag) {
        this.mPaymentFlag = paymentFlag;
    }
    
    public Integer getNbBenef() {
        return this.mNbBenef;
    }
    
    public void setNbBenef(final Integer nbBenef) {
        this.mNbBenef = nbBenef;
    }
    
    public String getBenefList() {
        return this.mBenefList;
    }
    
    public void setBenefList(final String benefList) {
        this.mBenefList = benefList;
    }
    
    public String getWarning1() {
        return this.mWarning1;
    }
    
    public void setWarning1(final String warning1) {
        this.mWarning1 = warning1;
    }
    
    public String getWarning2() {
        return this.mWarning2;
    }
    
    public void setWarning2(final String warning2) {
        this.mWarning2 = warning2;
    }
    
    public String getPec() {
        return this.mPec;
    }
    
    public void setPec(final String pec) {
        this.mPec = pec;
    }
    
    public String getInsuranceNature() {
        return this.mInsuranceNature;
    }
    
    public void setInsuranceNature(final String insuranceNature) {
        this.mInsuranceNature = insuranceNature;
    }
    
    public String getSituation() {
        return this.mSituation;
    }
    
    public void setSituation(final String situation) {
        this.mSituation = situation;
    }
    
    public String getModTicket() {
        return this.mModTicket;
    }
    
    public void setModTicket(final String modTicket) {
        this.mModTicket = modTicket;
    }
    
    public Double getPecRatio() {
        return this.mPecRatio;
    }
    
    public void setPecRatio(final Double pecRatio) {
        this.mPecRatio = pecRatio;
    }
    
    public String getMessageError() {
        return this.mMessageError;
    }
    
    public void setMessageError(final String messageError) {
        this.mMessageError = messageError;
    }
    
    public String toString() {
        return " [mRequestId=" + this.mRequestId + ", mRequestResult=" + this.mRequestResult + ", mPaymentFlag=" + this.mPaymentFlag + ", mNbBenef=" + this.mNbBenef + ", mBenefList=" + this.mBenefList + ", mWarning1=" + this.mWarning1 + ", mWarning2=" + this.mWarning2 + ", mPec=" + this.mPec + ", mInsuranceNature=" + this.mInsuranceNature + ", mSituation=" + this.mSituation + ", mModTicket=" + this.mModTicket + ", mPecRatio=" + this.mPecRatio + ", mMessageError=" + this.mMessageError + "]";
    }
}

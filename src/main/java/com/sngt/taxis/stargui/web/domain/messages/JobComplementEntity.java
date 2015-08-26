package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

public class JobComplementEntity extends AbstractEntity
{
    @Documentation("Identifiant de course")
    @JsonProperty("fi")
    private Integer mFareId;
    @Documentation("Guidage")
    @JsonProperty("g")
    private String mGuidance;
    @Documentation("Non Charge")
    @JsonProperty("nt")
    private Integer mNonTake;
    @Documentation("dateheure de saisie")
    @JsonProperty("di")
    private String mInputDate;
    @Documentation("dateheure due")
    @JsonProperty("da")
    private String mDueDate;
    @Documentation("Relev\u00e9")
    @JsonProperty("rlv")
    private String mRlv;
    @Documentation("Plafonds")
    @JsonProperty("uc")
    private List<Integer> mUpperCoeff;
    @Documentation("Impression")
    @JsonProperty("pr")
    private boolean mToPrint;
    @Documentation("CPAM")
    @JsonProperty("cpam")
    private boolean mCpam;
    @Documentation("Commentaires")
    @JsonProperty("cmt")
    private String mComment;
    
    public JobComplementEntity() {
        super(MQMessageType.JOB_CPLT.getType());
    }
    
    public Integer getFareId() {
        return this.mFareId;
    }
    
    public void setFareId(final Integer fareId) {
        this.mFareId = fareId;
    }
    
    public String getGuidance() {
        return this.mGuidance;
    }
    
    public void setGuidance(final String guidance) {
        this.mGuidance = guidance;
    }
    
    public Integer getNonTake() {
        return this.mNonTake;
    }
    
    public void setNonTake(final Integer nonTake) {
        this.mNonTake = nonTake;
    }
    
    public String getInputDate() {
        return this.mInputDate;
    }
    
    public void setInputDate(final String inputDate) {
        this.mInputDate = inputDate;
    }
    
    public String getDueDate() {
        return this.mDueDate;
    }
    
    public void setDueDate(final String dueDate) {
        this.mDueDate = dueDate;
    }
    
    public String getRlv() {
        return this.mRlv;
    }
    
    public void setRlv(final String rlv) {
        this.mRlv = rlv;
    }
    
    public List<Integer> getUpperCoeff() {
        if (this.mUpperCoeff == null) {
            this.mUpperCoeff = new ArrayList<Integer>();
        }
        return this.mUpperCoeff;
    }
    
    public void setUpperCoeff(final List<Integer> upperCoeff) {
        this.mUpperCoeff = upperCoeff;
    }
    
    public boolean isToPrint() {
        return this.mToPrint;
    }
    
    public void setToPrint(final boolean toPrint) {
        this.mToPrint = toPrint;
    }
    
    public String getComment() {
        return this.mComment;
    }
    
    public void setComment(final String comment) {
        this.mComment = comment;
    }
    
    public boolean isCpam() {
        return this.mCpam;
    }
    
    public void setCpam(final boolean cpam) {
        this.mCpam = cpam;
    }
    
    public void initEg() {
        this.mGuidance = "GPS";
        this.mNonTake = 12;
        this.mInputDate = "12-01-12A07H41";
        this.mDueDate = "12-01-12A07H41";
        this.mRlv = "N";
        this.mUpperCoeff = Arrays.asList(1, 2);
        this.mToPrint = true;
        this.mComment = "Je fais un commentaire";
        this.mFareId = 1;
        this.mCpam = true;
    }
    
    public String toString() {
        return "[mFareId=" + this.mFareId + ", mGuidance=" + this.mGuidance + ", mNonTake=" + this.mNonTake + ", mInputDate=" + this.mInputDate + ", mDueDate=" + this.mDueDate + ", mRlv=" + this.mRlv + ", mUpperCoeff=" + this.mUpperCoeff + ", mToPrint=" + this.mToPrint + ", mCpam=" + this.mCpam + ", mComment=" + this.mComment + "]";
    }
}

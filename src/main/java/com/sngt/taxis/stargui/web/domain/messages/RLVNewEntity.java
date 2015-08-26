package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class RLVNewEntity extends AbstractEntity
{
    private static final long serialVersionUID = 1L;
    @Documentation("Numero Course")
    @JsonProperty("i")
    private Integer mFareId;
    @Documentation("Zone")
    @JsonProperty("an")
    private Integer mAreaNumber;
    @Documentation("montant saisi par le chauffeur")
    @JsonProperty("am")
    private Double mAmount;
    @Documentation(" Nb d'heures d'attente factur\u00e9es")
    @JsonProperty("hr")
    private Integer mNbHour;
    @Documentation(" Nb de minutes d'attente factur\u00e9es")
    @JsonProperty("mn")
    private Integer mNbMinute;
    @Documentation("La course a \u00e9t\u00e9 saisie manuellement ou automatiquement")
    @JsonProperty("iaa")
    private boolean mInputAreaAuto;
    @Documentation("Montant plafond")
    @JsonProperty("mam")
    private Double mMaxAmount;
    @Documentation("Pr\u00e9cisions ")
    @JsonProperty("pr")
    private String mPrecisions;
    
    public RLVNewEntity() {
        super(MQMessageType.RLV_NEW.getType());
    }
    
    public void initEg() {
        this.mFareId = 123;
        this.mAreaNumber = 540;
        this.mAmount = 10.5;
        this.mNbHour = 2;
        this.mNbMinute = 30;
        this.mInputAreaAuto = false;
        this.mMaxAmount = 1254556.9;
    }
    
    public Integer getFareId() {
        return this.mFareId;
    }
    
    public void setFareId(final Integer fareId) {
        this.mFareId = fareId;
    }
    
    public Integer getAreaNumber() {
        return this.mAreaNumber;
    }
    
    public void setAreaNumber(final Integer areaNumber) {
        this.mAreaNumber = areaNumber;
    }
    
    public Double getAmount() {
        return this.mAmount;
    }
    
    public void setAmount(final Double amount) {
        this.mAmount = amount;
    }
    
    public Integer getNbHour() {
        return this.mNbHour;
    }
    
    public void setNbHour(final Integer nbHour) {
        this.mNbHour = nbHour;
    }
    
    public Integer getNbMinute() {
        return this.mNbMinute;
    }
    
    public void setNbMinute(final Integer nbMinute) {
        this.mNbMinute = nbMinute;
    }
    
    public boolean isInputAreaAuto() {
        return this.mInputAreaAuto;
    }
    
    public void setInputAreaAuto(final boolean inputAreaAuto) {
        this.mInputAreaAuto = inputAreaAuto;
    }
    
    public Double getMaxAmount() {
        return this.mMaxAmount;
    }
    
    public void setMaxAmount(final Double maxAmount) {
        this.mMaxAmount = maxAmount;
    }
    
    public String toString() {
        return "[mFareId=" + this.mFareId + ", mAreaNumber=" + this.mAreaNumber + ", mAmount=" + this.mAmount + ", mNbHour=" + this.mNbHour + ", mNbMinute=" + this.mNbMinute + ", mInputAreaAuto=" + this.mInputAreaAuto + ", mMaxAmount=" + this.mMaxAmount + ",]";
    }
}

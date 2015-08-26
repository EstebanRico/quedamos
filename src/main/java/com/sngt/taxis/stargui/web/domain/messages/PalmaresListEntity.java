package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

public class PalmaresListEntity extends AbstractEntity
{
    @Documentation("Type de r\u00e9sa")
    @JsonProperty("pt")
    private int mPalmaresType;
    @Documentation("Liste de palmares")
    @JsonProperty("pl")
    private List<Palmares> mPalmaresList;
    
    public PalmaresListEntity() {
        super(MQMessageType.PALMARES.getType());
        this.mPalmaresList = new ArrayList();
    }
    
    public void initEg() {
    }
    
    public int getPalmaresType() {
        return this.mPalmaresType;
    }
    
    public void setPalmaresType(final int palmaresType) {
        this.mPalmaresType = palmaresType;
    }
    
    public List<Palmares> getPalmaresList() {
        return (List<Palmares>)this.mPalmaresList;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" [mPalmaresType=").append(this.mPalmaresType);
        sb.append(" , mPalmaresList=");
        for (final Palmares palmares : this.mPalmaresList) {
            sb.append(palmares).append(",");
        }
        return sb.toString();
    }
}

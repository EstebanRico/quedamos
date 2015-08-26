package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class NavigationEntity extends AbstractEntityPart
{
    private static final long serialVersionUID = 1L;
    @JsonProperty("nav")
    private boolean mNavigation;
    @JsonProperty("cy")
    private boolean mCoyotte;
    @JsonProperty("ht")
    private boolean mHdTraffic;
    
    public NavigationEntity() {
        this.mNavigation = false;
        this.mCoyotte = false;
        this.mHdTraffic = false;
    }
    
    public boolean isNavigation() {
        return this.mNavigation;
    }
    
    public void setNavigation(final boolean navigation) {
        this.mNavigation = navigation;
    }
    
    public boolean isCoyotte() {
        return this.mCoyotte;
    }
    
    public void setCoyotte(final boolean coyotte) {
        this.mCoyotte = coyotte;
    }
    
    public boolean isHdTraffic() {
        return this.mHdTraffic;
    }
    
    public void setHdTraffic(final boolean hdTraffic) {
        this.mHdTraffic = hdTraffic;
    }
    
    public String toString() {
        return " [Navigation=" + this.mNavigation + ", Coyotte=" + this.mCoyotte + ", HdTraffic=" + this.mHdTraffic + "]";
    }
    
    public void initEg() {
    }
}

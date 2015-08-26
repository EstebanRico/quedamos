package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;

public class AutoriseEntity extends AbstractEntity
{
    private static final long serialVersionUID = 548307699913710354L;
    @JsonProperty("fl")
    @Documentation("Flotte")
    private Integer mFlotte;
    @JsonProperty("co")
    @Documentation("Contrat")
    private String mContrat;
    @JsonProperty("do")
    @Documentation("Doubleur")
    private String mDoubleur;
    @JsonProperty("navi")
    @Documentation("Navigation")
    private NavigationEntity mNavigation;
    @JsonProperty("cpam")
    @Documentation("CPAM")
    private boolean mCpam;
    @JsonProperty("n")
    @Documentation("Nom")
    private String mName;
    @JsonProperty("p")
    @Documentation("Pr\u00e9nom")
    private String mPrenom;
    @JsonProperty("id")
    @Documentation("Identifiant")
    private String mIdent;
    @JsonProperty("im")
    @Documentation("Immatriculation")
    private String mImmat;
    @JsonProperty("li")
    @Documentation("Licence")
    private String mLicence;
    @JsonProperty("fa")
    @Documentation("Fact")
    private String mFact;
    
    public void initEg() {
        this.mFlotte = 1;
        this.mContrat = "Jour";
        this.mDoubleur = "CODERADIOxxxx";
        (this.mNavigation = new NavigationEntity()).initEg();
        this.mCpam = true;
        this.mName = "THORNER";
        this.mPrenom = "Joel";
        this.mIdent = "1 75 06 99 203 455";
        this.mImmat = "XXXXXIMMAT";
        this.mLicence = "????";
        this.mFact = "????";
    }
    
    public AutoriseEntity() {
        super(MQMessageType.AUTORISE.getType());
    }
    
    public Integer getFlotte() {
        return this.mFlotte;
    }
    
    public void setFlotte(final Integer flotte) {
        this.mFlotte = flotte;
    }
    
    public String getContrat() {
        return this.mContrat;
    }
    
    public void setContrat(final String contrat) {
        this.mContrat = contrat;
    }
    
    public String getDoubleur() {
        return this.mDoubleur;
    }
    
    public void setDoubleur(final String doubleur) {
        this.mDoubleur = doubleur;
    }
    
    public NavigationEntity getNavigation() {
        if (this.mNavigation == null) {
            this.mNavigation = new NavigationEntity();
        }
        return this.mNavigation;
    }
    
    public void setNavigation(final NavigationEntity navigation) {
        this.mNavigation = navigation;
    }
    
    public boolean isCpam() {
        return this.mCpam;
    }
    
    public void setCpam(final boolean cpam) {
        this.mCpam = cpam;
    }
    
    public String getName() {
        return this.mName;
    }
    
    public void setName(final String name) {
        this.mName = name;
    }
    
    public String getPrenom() {
        return this.mPrenom;
    }
    
    public void setPrenom(final String prenom) {
        this.mPrenom = prenom;
    }
    
    public String getIdent() {
        return this.mIdent;
    }
    
    public void setIdent(final String ident) {
        this.mIdent = ident;
    }
    
    public String getImmat() {
        return this.mImmat;
    }
    
    public void setImmat(final String immat) {
        this.mImmat = immat;
    }
    
    public String getLicence() {
        return this.mLicence;
    }
    
    public void setLicence(final String licence) {
        this.mLicence = licence;
    }
    
    public String getFact() {
        return this.mFact;
    }
    
    public void setFact(final String fact) {
        this.mFact = fact;
    }
    
    public boolean isDoubleur() {
        return this.mDoubleur != null && this.mDoubleur != "";
    }
    
    public String toString() {
        return "[ Flotte=" + this.mFlotte + ", Contrat=" + this.mContrat + ", Doubleur=" + this.mDoubleur + ", Navigation=" + this.mNavigation + ",CPAM=" + this.mCpam + "[Name=" + this.mName + ", Prenom=" + this.mPrenom + ", Ident=" + this.mIdent + ", Immat=" + this.mImmat + ", Licence=" + this.mLicence + ", Fact=" + this.mFact + "]]";
    }
}

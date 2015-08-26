package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

public class RLVCPAMEntity extends AbstractEntityWithCommonPart
{
    @Documentation("Code chauffeur r\u00e9cup\u00e9r\u00e9 dans la r\u00e9ponse TWS")
    @JsonProperty("cc")
    private Integer mCodeChauffeur;
    @Documentation("Dernier num\u00e9ro de facture contenu dans le message")
    @JsonProperty("nf")
    private Integer mNumeroFacture;
    @Documentation("Num\u00e9ro unique de la course contenu dans le message JOB_CPLT")
    @JsonProperty("i")
    private Integer mNumeroCourse;
    @Documentation("Tel passager: Saisi dans le module CPAM")
    @JsonProperty("tp")
    private String mTelephonePassager;
    @Documentation("NIR: saisie CPAM ou carte vitale")
    @JsonProperty("nir")
    private String mNIR;
    @Documentation("Nom de l'assur\u00e9 lu depuis la carte vitale")
    @JsonProperty("nom")
    private String mNomAssure;
    @Documentation("Pr\u00e9nom de l'assur\u00e9 lu depuis la carte vitale")
    @JsonProperty("prenom")
    private String mPrenomAssure;
    @Documentation("Code organisme: saisie CPAM ou carte vitale")
    @JsonProperty("co")
    private String mCodeOrganisme;
    @Documentation("Date situation particuliere: date AT/MP ou maternit\u00e9 saisie CPAM ou PEC+")
    @JsonProperty("dst")
    private Date mDateSituationParticuliere;
    @Documentation("Date fin droit: saisie CPAM")
    @JsonProperty("dfd")
    private Date mDateFinDroit;
    @Documentation("1 si Tx de PEC vaut 65% ou 85%, 2 si  Tx de PEC vaut 100% et situation de PEC vaut ALD, 3 si 100%  et situation de PEC vaut invalidit\u00e9 OU 9 si 100% et situation particuli\u00e8res vaut fond de solidarit\u00e9 ")
    @JsonProperty("tpec")
    private Integer mTauxPEC;
    @Documentation("Type attestation: 1 si \"Standard\", 2 si \"AME\", 3 si \"CMUC\", 21 si \"AMEC\"")
    @JsonProperty("ta")
    private Integer mTypeAttestation;
    @Documentation("Nature assurance: saisie CPAM ou code utilis\u00e9 pour PEC+ (30=\"Maternit\u00e9\", 41=\"AT/MP\", 13=\"Maladie (13)\", 10 = \"Maladie\")")
    @JsonProperty("na")
    private Integer mNatureAssurance;
    @Documentation("Naissance Beneficiaire: saisie CPAM ou carte vitale")
    @JsonProperty("nb")
    private Date mNaissanceBeneficiaire;
    @Documentation("Lien beneficiaire: C pour conjoint, E pour enfant, M pour vie maritale, A pour autre")
    @JsonProperty("lba")
    private Character mLienBeneficiaire;
    @Documentation("Rang Naissance: sur l'\u00e9cran lien passager avec l'assur\u00e9, si r\u00e9ponse = Non alors 1. Sinon, valeur saisie du rang")
    @JsonProperty("rn")
    private Integer mRangNaissance;
    @Documentation("Numero prescripteur: Saisie CPAM")
    @JsonProperty("np")
    private String mNumPrescripteur;
    @Documentation("Date Prescription: saisie CPAM")
    @JsonProperty("dp")
    private Date mDatePrescription;
    @Documentation("Date Entente: PMT")
    @JsonProperty("de")
    private Date mDateEntente;
    @Documentation("Heure depart: date du meter ON")
    @JsonProperty("dhd")
    private Date mDateHeureDepart;
    @JsonProperty("dloc")
    @Documentation("Position d\u00e9part")
    private Geolocation mLocationDepart;
    @JsonProperty("sploc")
    @Documentation("Position sur place")
    private Geolocation mLocationSurPlace;
    @Documentation("Heure depart: date du meter ON")
    @JsonProperty("spdh")
    private Date mDateHeureSurPlace;
    @JsonProperty("aloc")
    @Documentation("Position au meter DUE")
    private Geolocation mLocationArrivee;
    @Documentation("Heure depart: date du meter DUE")
    @JsonProperty("adh")
    private Date mDateHeureArrivee;
    @Documentation("num\u00e9ro transporteur : « ident » dans le message AUTORISE")
    @JsonProperty("nt")
    private Integer mNumTransporteur;
    @Documentation("License dans le message autorise")
    @JsonProperty("nas")
    private Integer mNumAutorisationStationnement;
    @Documentation("immat dans AUTORISE")
    @JsonProperty("imm")
    private String mImmatriculation;
    @Documentation("nom dans AUTORISE")
    @JsonProperty("nomc")
    private String mNomChauffeur;
    @Documentation("prenom dans AUTORISE")
    @JsonProperty("prec")
    private String mPrenomChauffeur;
    @Documentation("suite des valeurs des cases coch\u00e9es pour les tarifs, s\u00e9par\u00e9es par des virgules")
    @JsonProperty("tc")
    private String mTarifCompteur;
    @Documentation("Total course - saisie des suppl\u00e9ments non remboursables - d\u00e9passement de l'approche")
    @JsonProperty("thsnr")
    private Float mTotalHorsSuppNonRemboursable;
    @Documentation("saisie des suppl\u00e9ments remboursables")
    @JsonProperty("sr")
    private Float mSuppRemboursable;
    @Documentation("saisie des suppl\u00e9ments non remboursables")
    @JsonProperty("snr")
    private Float mSuppNonRemboursable;
    @Documentation("Taux param\u00e9tr\u00e9 dans STAR2015")
    @JsonProperty("tr")
    private Integer mTauxRemise;
    @Documentation("Total course hors suppl\u00e9ments non remboursables remis\u00e9")
    @JsonProperty("bcpam")
    private Float mBaseCPAM;
    @Documentation("Base CPAM * Taux de PEC")
    @JsonProperty("pcpam")
    private Float mPartCPAM;
    @Documentation("Montant restant \u00e0 payer dans le v\u00e9hicule saisi")
    @JsonProperty("pab")
    private Float mPaiementABord;
    @Documentation("1 si PEC 100% , 2 si PEC 65 ou 85%, 3 sinon")
    @JsonProperty("cr")
    private Integer mCodeReglement;
    @Documentation("V pour vitale, A pour AMELI (CPAMP_REPLY de type A),O pour Autre")
    @JsonProperty("sd")
    private Character mSourceDonnees;
    @Documentation("N si pas de retour PEC+, P si partielle, T si Totale")
    @JsonProperty("upec")
    private Character mUtilisationPECPlus;
    @Documentation("Montant d\u2019approche saisi dans le module CPAM")
    @JsonProperty("ma")
    private Float mMontantApproche;
    
    public RLVCPAMEntity() {
        super(MQMessageType.RLV_CPAM.getType());
    }
    
    public RLVCPAMEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.RLV_CPAM.getType(), geolocation, taximeterState, time);
    }
    
    public void initEg() {
    }
    
    public Integer getCodeChauffeur() {
        return this.mCodeChauffeur;
    }
    
    public void setCodeChauffeur(final Integer codeChauffeur) {
        this.mCodeChauffeur = codeChauffeur;
    }
    
    public Integer getNumeroFacture() {
        return this.mNumeroFacture;
    }
    
    public void setNumeroFacture(final Integer numeroFacture) {
        this.mNumeroFacture = numeroFacture;
    }
    
    public Integer getNumeroCourse() {
        return this.mNumeroCourse;
    }
    
    public void setNumeroCourse(final Integer numeroCourse) {
        this.mNumeroCourse = numeroCourse;
    }
    
    public String getTelephonePassager() {
        return this.mTelephonePassager;
    }
    
    public void setTelephonePassager(final String telephonePassager) {
        this.mTelephonePassager = telephonePassager;
    }
    
    public String getNIR() {
        return this.mNIR;
    }
    
    public void setNIR(final String nIR) {
        this.mNIR = nIR;
    }
    
    public String getNomAssure() {
        return this.mNomAssure;
    }
    
    public void setNomAssure(final String nomAssure) {
        this.mNomAssure = nomAssure;
    }
    
    public String getPrenomAssure() {
        return this.mPrenomAssure;
    }
    
    public void setPrenomAssure(final String prenomAssure) {
        this.mPrenomAssure = prenomAssure;
    }
    
    public String getCodeOrganisme() {
        return this.mCodeOrganisme;
    }
    
    public void setCodeOrganisme(final String codeOrganisme) {
        this.mCodeOrganisme = codeOrganisme;
    }
    
    public Date getDateSituationParticuliere() {
        return this.mDateSituationParticuliere;
    }
    
    public void setDateSituationParticuliere(final Date dateSituationParticuliere) {
        this.mDateSituationParticuliere = dateSituationParticuliere;
    }
    
    public Date getDateFinDroit() {
        return this.mDateFinDroit;
    }
    
    public void setDateFinDroit(final Date dateFinDroit) {
        this.mDateFinDroit = dateFinDroit;
    }
    
    public Integer getTauxPEC() {
        return this.mTauxPEC;
    }
    
    public void setTauxPEC(final Integer tauxPEC) {
        this.mTauxPEC = tauxPEC;
    }
    
    public Integer getTypeAttestation() {
        return this.mTypeAttestation;
    }
    
    public void setTypeAttestation(final Integer typeAttestation) {
        this.mTypeAttestation = typeAttestation;
    }
    
    public Integer getNatureAssurance() {
        return this.mNatureAssurance;
    }
    
    public void setNatureAssurance(final Integer natureAssurance) {
        this.mNatureAssurance = natureAssurance;
    }
    
    public Date getNaissanceBeneficiaire() {
        return this.mNaissanceBeneficiaire;
    }
    
    public void setNaissanceBeneficiaire(final Date naissanceBeneficiaire) {
        this.mNaissanceBeneficiaire = naissanceBeneficiaire;
    }
    
    public Character getLienBeneficiaire() {
        return this.mLienBeneficiaire;
    }
    
    public void setLienBeneficiaire(final Character lienBeneficiaire) {
        this.mLienBeneficiaire = lienBeneficiaire;
    }
    
    public Integer getRangNaissance() {
        return this.mRangNaissance;
    }
    
    public void setRangNaissance(final Integer rangNaissance) {
        this.mRangNaissance = rangNaissance;
    }
    
    public String getNumPrescripteur() {
        return this.mNumPrescripteur;
    }
    
    public void setNumPrescripteur(final String numPrescripteur) {
        this.mNumPrescripteur = numPrescripteur;
    }
    
    public Date getDatePrescription() {
        return this.mDatePrescription;
    }
    
    public void setDatePrescription(final Date datePrescription) {
        this.mDatePrescription = datePrescription;
    }
    
    public Date getDateEntente() {
        return this.mDateEntente;
    }
    
    public void setDateEntente(final Date dateEntente) {
        this.mDateEntente = dateEntente;
    }
    
    public Date getDateHeureDepart() {
        return this.mDateHeureDepart;
    }
    
    public void setDateHeureDepart(final Date dateHeureDepart) {
        this.mDateHeureDepart = dateHeureDepart;
    }
    
    public Geolocation getLocationDepart() {
        return this.mLocationDepart;
    }
    
    public void setLocationDepart(final Geolocation locationDepart) {
        this.mLocationDepart = locationDepart;
    }
    
    public Geolocation getLocationSurPlace() {
        return this.mLocationSurPlace;
    }
    
    public void setLocationSurPlace(final Geolocation locationSurPlace) {
        this.mLocationSurPlace = locationSurPlace;
    }
    
    public Date getDateHeureSurPlace() {
        return this.mDateHeureSurPlace;
    }
    
    public void setDateHeureSurPlace(final Date dateHeureSurPlace) {
        this.mDateHeureSurPlace = dateHeureSurPlace;
    }
    
    public Geolocation getLocationArrivee() {
        return this.mLocationArrivee;
    }
    
    public void setLocationArrivee(final Geolocation locationArrivee) {
        this.mLocationArrivee = locationArrivee;
    }
    
    public Date getDateHeureArrivee() {
        return this.mDateHeureArrivee;
    }
    
    public void setDateHeureArrivee(final Date dateHeureArrivee) {
        this.mDateHeureArrivee = dateHeureArrivee;
    }
    
    public Integer getNumTransporteur() {
        return this.mNumTransporteur;
    }
    
    public void setNumTransporteur(final Integer numTransporteur) {
        this.mNumTransporteur = numTransporteur;
    }
    
    public Integer getNumAutorisationStationnement() {
        return this.mNumAutorisationStationnement;
    }
    
    public void setNumAutorisationStationnement(final Integer numAutorisationStationnement) {
        this.mNumAutorisationStationnement = numAutorisationStationnement;
    }
    
    public String getImmatriculation() {
        return this.mImmatriculation;
    }
    
    public void setImmatriculation(final String immatriculation) {
        this.mImmatriculation = immatriculation;
    }
    
    public String getNomChauffeur() {
        return this.mNomChauffeur;
    }
    
    public void setNomChauffeur(final String nomChauffeur) {
        this.mNomChauffeur = nomChauffeur;
    }
    
    public String getPrenomChauffeur() {
        return this.mPrenomChauffeur;
    }
    
    public void setPrenomChauffeur(final String prenomChauffeur) {
        this.mPrenomChauffeur = prenomChauffeur;
    }
    
    public String getTarifCompteur() {
        return this.mTarifCompteur;
    }
    
    public void setTarifCompteur(final String tarifCompteur) {
        this.mTarifCompteur = tarifCompteur;
    }
    
    public Float getTotalHorsSuppNonRemboursable() {
        return this.mTotalHorsSuppNonRemboursable;
    }
    
    public void setTotalHorsSuppNonRemboursable(final Float totalHorsSuppNonRemboursable) {
        this.mTotalHorsSuppNonRemboursable = totalHorsSuppNonRemboursable;
    }
    
    public Float getSuppRemboursable() {
        return this.mSuppRemboursable;
    }
    
    public void setSuppRemboursable(final Float suppRemboursable) {
        this.mSuppRemboursable = suppRemboursable;
    }
    
    public Float getSuppNonRemboursable() {
        return this.mSuppNonRemboursable;
    }
    
    public void setSuppNonRemboursable(final Float suppNonRemboursable) {
        this.mSuppNonRemboursable = suppNonRemboursable;
    }
    
    public Integer getTauxRemise() {
        return this.mTauxRemise;
    }
    
    public void setTauxRemise(final Integer tauxRemise) {
        this.mTauxRemise = tauxRemise;
    }
    
    public Float getBaseCPAM() {
        return this.mBaseCPAM;
    }
    
    public void setBaseCPAM(final Float baseCPAM) {
        this.mBaseCPAM = baseCPAM;
    }
    
    public Float getPartCPAM() {
        return this.mPartCPAM;
    }
    
    public void setPartCPAM(final Float partCPAM) {
        this.mPartCPAM = partCPAM;
    }
    
    public Float getPaiementABord() {
        return this.mPaiementABord;
    }
    
    public void setPaiementABord(final Float paiementABord) {
        this.mPaiementABord = paiementABord;
    }
    
    public Integer getCodeReglement() {
        return this.mCodeReglement;
    }
    
    public void setCodeReglement(final Integer codeReglement) {
        this.mCodeReglement = codeReglement;
    }
    
    public Character getSourceDonnees() {
        return this.mSourceDonnees;
    }
    
    public void setSourceDonnees(final Character sourceDonnees) {
        this.mSourceDonnees = sourceDonnees;
    }
    
    public Character getUtilisationPECPlus() {
        return this.mUtilisationPECPlus;
    }
    
    public void setUtilisationPECPlus(final Character utilisationPECPlus) {
        this.mUtilisationPECPlus = utilisationPECPlus;
    }
    
    public Float getMontantApproche() {
        return this.mMontantApproche;
    }
    
    public void setMontantApproche(final Float montantApproche) {
        this.mMontantApproche = montantApproche;
    }
    
    public String toString() {
        return " [mCodeChauffeur=" + this.mCodeChauffeur + ", mNumeroFacture=" + this.mNumeroFacture + ", mNumeroCourse=" + this.mNumeroCourse + ", mTelephonePassager=" + this.mTelephonePassager + ", mNIR=" + this.mNIR + ", mNomAssure=" + this.mNomAssure + ", mPrenomAssure=" + this.mPrenomAssure + ", mCodeOrganisme=" + this.mCodeOrganisme + ", mDateSituationParticuliere=" + this.mDateSituationParticuliere + ", mDateFinDroit=" + this.mDateFinDroit + ", mTauxPEC=" + this.mTauxPEC + ", mTypeAttestation=" + this.mTypeAttestation + ", mNatureAssurance=" + this.mNatureAssurance + ", mNaissanceBeneficiaire=" + this.mNaissanceBeneficiaire + ", mLienBeneficiaire=" + this.mLienBeneficiaire + ", mRangNaissance=" + this.mRangNaissance + ", mNumPrescripteur=" + this.mNumPrescripteur + ", mDatePrescription=" + this.mDatePrescription + ", mDateEntente=" + this.mDateEntente + ", mDateHeureDepart=" + this.mDateHeureDepart + ", mLocationDepart=" + this.mLocationDepart + ", mLocationSurPlace=" + this.mLocationSurPlace + ", mDateHeureSurPlace=" + this.mDateHeureSurPlace + ", mLocationArrivee=" + this.mLocationArrivee + ", mDateHeureArrivee=" + this.mDateHeureArrivee + ", mNumTransporteur=" + this.mNumTransporteur + ", mNumAutorisationStationnement=" + this.mNumAutorisationStationnement + ", mImmatriculation=" + this.mImmatriculation + ", mNomChauffeur=" + this.mNomChauffeur + ", mPrenomChauffeur=" + this.mPrenomChauffeur + ", mTarifCompteur=" + this.mTarifCompteur + ", mTotalHorsSuppNonRemboursable=" + this.mTotalHorsSuppNonRemboursable + ", mSuppRemboursable=" + this.mSuppRemboursable + ", mSuppNonRemboursable=" + this.mSuppNonRemboursable + ", mTauxRemise=" + this.mTauxRemise + ", mBaseCPAM=" + this.mBaseCPAM + ", mPartCPAM=" + this.mPartCPAM + ", mPaiementABord=" + this.mPaiementABord + ", mCodeReglement=" + this.mCodeReglement + ", mSourceDonnees=" + this.mSourceDonnees + ", mUtilisationPECPlus=" + this.mUtilisationPECPlus + ", mMontantApproche=" + this.mMontantApproche + "]";
    }
}

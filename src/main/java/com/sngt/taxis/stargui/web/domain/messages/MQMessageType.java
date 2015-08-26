package com.sngt.taxis.stargui.web.domain.messages;

public enum MQMessageType {
    GPS_UPDATE("2300", "GPS_UPDATE", "NA"),
    SIGN_IN("2100", "SIGN_IN", "Identifi\u00e9 "),
    ACK("4000", "Ack", "NA"),
    NO_ACK("0003", "NoAck", "NoAck"),
    OFFER_DISP("2213", "OFFER_DISP", "En Offre"),
    REJECT_OFFER("3320", "REJET", "NA"),
    NO_ACCEPT("3321", "NO_ACCEPT", "NA"),
    CHRONOMETER("2208", "CHRONOMETER", "NA"),
    ASSIGN_DISP("2223", "ASSIGN_DISP", "NA"),
    STATUS_DISP("2103", "STATUS_DISP", "NA"),
    ENDIRECTION("2120", "ENDIRECTION", "Pr\u00e9-inscrit en zone "),
    BOOK_IN("2110", "BOOK_IN", "Inscrit en zone "),
    PROMPT_DISP("2301", "PROMPT_DISP", "NA"),
    JOB_CPLT("2001", "JOB_COMPLEMENT", ""),
    INFO_CHAUFFEUR("2206", "INFO_CHAUFFEUR", ""),
    AUTORISE("0210", "AUTORISE", ""),
    GROUP_ASSIGN("0A02", "GROUP_ASSIGN", ""),
    ACCEPT("21D0", "ACCEPT", "En Approche"),
    PAUSE("3370", "PAUSE", "En Pause"),
    ZONE_INFO("2140", "ZONE_INFO", ""),
    BONUS("2207", "BONUS", ""),
    DELAI("2170", "DELAI", ""),
    EXPIRE("0A32", "EXPIRE", ""),
    RANG("21E0", "RANG", "RANG"),
    BOOK_OFF("2160", "BOOK_OFF", "BOOK_OFF"),
    DEAUTH("0110", "DEAUTH", ""),
    SIGN_OFF("3350", "SIGN_OFF", "SIGN_OFF"),
    BASCULE("33C0", "BASCULE", "BASCULE"),
    READY("0001", "READY", "READY"),
    NOT_READY("0002", "NOT_READY", "NOT_READY"),
    SUR_PLACE("33A0", "SUR_PLACE", "SUR_PLACE"),
    NON_CHARGE("2190", "NON_CHARGE", "NON_CHARGE"),
    CLIENT_A_BORD("21F0", "CHARGE_NEW", "Client \u00e0 bord"),
    MESSAGE("2130", "MESSAGE", ""),
    VEH_IN("2320", "VEH_IN", "Retour vehicule"),
    VEH_OUT("2310", "VEH_OUT", "Sortie v\u00e9hicule"),
    COURSE_ANNULEE("2209", "COURSE_ANNULEE", "Course annulee"),
    RLV_CPAM("21B2", "RLV_CPAM", "Relev\u00e9 CPAM"),
    RLV_NEW("21B1", "RLV_NEW", "Relev\u00e9 chauffeur"),
    ACK_CENTRAL("2007", "ACK_CENTRAL", ""),
    METTER("3110", "METTER", ""),
    REDISPATCH("2210", "REDISPATCH", ""),
    HIA("3200", "HIA", ""),
    ZONE_BCST("1330", "ZONE_BCST", "Zone broad cast"),
    DRIVER_QUERY("22D1", "DRIVER_QUERY", ""),
    PALMARES("2204", "PALMARES", "PALMARES"),
    CPAM_REQUEST("21C1", "CPAM_REQUEST", "CPAM_REQUEST"),
    CPAM_REPLY("2008", "CPAM_REPLY", "CPAM_REPLY"),
    ALARME("2180", "ALARME", "ALARME"),
    PRINT("2302", "PRINT", "PRINT"),
    ABANDON_COURSE("2403", "ABANDON_COURSE", ""),
    STATIONNEMENT_IMPOSSIBLE("2404", "STATIONNEMENT_IMPOSSIBLE", ""),
    REFUS("2405", "REFUS", ""),
    OFFER_ENCHER("1333", "ENCHERE", "En ench\u00e8re"),
    ENCHERE_ACCEPT("1334", "ENCHERE ACCEPT", ""),
    STAT_DIST("1111", "STAT_DIST", "");
    private String mType;
    private String libelle;
    private String status;

    MQMessageType(final String type, final String libelle, final String status) {
        this.mType = type;
        this.libelle = libelle;
        this.status = status;
    }

    public String getType() {
        return this.mType;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public static MQMessageType getMQMessageType(final String type) {
        for (final MQMessageType messageType : values()) {
            if (messageType.getType().equals(type)) {
                return messageType;
            }
        }
        return null;
    }

    public String getStatus() {
        return this.status;
    }

}

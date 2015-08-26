package com.sngt.taxis.stargui.web.domain.messages;

import java.io.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageAlertJson implements Serializable
{
    private static final long serialVersionUID = 1L;
    @JsonProperty("i")
    private String id;
    @JsonProperty("cd")
    private Long cd;
    @JsonProperty("vd")
    private Long vd;
    @JsonProperty("f")
    private String from;
    @JsonProperty("c")
    private String cat;
    @JsonProperty("sc")
    private String subCat;
    @JsonProperty("d")
    private Map<String, Object> detail;
    @JsonProperty("la")
    private Float la;
    @JsonProperty("lo")
    private Float lo;
    @JsonProperty("a")
    private String adress;
    
    public MessageAlertJson() {
        this.detail = new HashMap();
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public Long getCd() {
        return this.cd;
    }
    
    public void setCd(final Long cd) {
        this.cd = cd;
    }
    
    public Long getVd() {
        return this.vd;
    }
    
    public void setVd(final Long vd) {
        this.vd = vd;
    }
    
    public String getFrom() {
        return this.from;
    }
    
    public void setFrom(final String from) {
        this.from = from;
    }
    
    public String getCat() {
        return this.cat;
    }
    
    public void setCat(final String cat) {
        this.cat = cat;
    }
    
    public String getSubCat() {
        return this.subCat;
    }
    
    public void setSubCat(final String subCat) {
        this.subCat = subCat;
    }
    
    public Map<String, Object> getDetail() {
        return (Map<String, Object>)this.detail;
    }
    
    public void setDetail(final Map<String, Object> detail) {
        this.detail = detail;
    }
    
    public Float getLa() {
        return this.la;
    }
    
    public void setLa(final Float la) {
        this.la = la;
    }
    
    public Float getLo() {
        return this.lo;
    }
    
    public void setLo(final Float lo) {
        this.lo = lo;
    }
    
    public String getAdress() {
        return this.adress;
    }
    
    public void setAdress(final String adress) {
        this.adress = adress;
    }
    
    public static long getSerialversionuid() {
        return 1L;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = 31 * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final MessageAlertJson other = (MessageAlertJson)obj;
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        }
        else if (!this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<String, Object> entry : this.detail.entrySet()) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
        }
        return "MessageAlertJson [id=" + this.id + ", cd=" + this.cd + ", vd=" + this.vd + ", from=" + this.from + ", cat=" + this.cat + ", subCat=" + this.subCat + ", detail=" + sb.toString() + ", la=" + this.la + ", lo=" + this.lo + ", adress=" + this.adress + "]";
    }
}

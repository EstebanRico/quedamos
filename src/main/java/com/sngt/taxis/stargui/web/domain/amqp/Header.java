package com.sngt.taxis.stargui.web.domain.amqp;

import java.io.*;

public class Header implements Serializable
{
    private static final long serialVersionUID = 5902237022053306163L;
    private long size;
    private long mid;
    private long idPackage;
    private String type;
    private long idResponse;
    
    public long getMid() {
        return this.mid;
    }
    
    public void setMid(final long mid) {
        this.mid = mid;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public long getSize() {
        return this.size;
    }
    
    public void setSize(final long size) {
        this.size = size;
    }
    
    public long getIdPackage() {
        return this.idPackage;
    }
    
    public void setIdPackage(final long idPackage) {
        this.idPackage = idPackage;
    }
    
    public long getIdResponse() {
        return this.idResponse;
    }
    
    public void setIdResponse(final long response) {
        this.idResponse = response;
    }

    @Override
    public String toString() {
        return "Header{" +
                "idPackage=" + idPackage +
                ", size=" + size +
                ", mid=" + mid +
                ", type='" + type + '\'' +
                ", idResponse=" + idResponse +
                '}';
    }
}

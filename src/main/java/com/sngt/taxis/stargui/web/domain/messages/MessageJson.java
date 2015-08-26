package com.sngt.taxis.stargui.web.domain.messages;

import java.io.*;

public class MessageJson implements Serializable
{
    private Integer mid;
    private String message;
    
    public Integer getMid() {
        return this.mid;
    }
    
    public void setMid(final Integer mid) {
        this.mid = mid;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
}

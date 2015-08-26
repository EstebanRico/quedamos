package com.sngt.taxis.stargui.web.domain.messages;

import java.io.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorMessageAlertJson implements Serializable
{
    private static final long serialVersionUID = 1L;
    @JsonProperty("s")
    private String status;
    @JsonProperty("m")
    private String messsage;
    @JsonProperty("ei")
    private List<String> errors;
    
    public ErrorMessageAlertJson() {
        this.errors = new ArrayList();
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public String getMesssage() {
        return this.messsage;
    }
    
    public void setMesssage(final String messsage) {
        this.messsage = messsage;
    }
    
    public List<String> getErrors() {
        return (List<String>)this.errors;
    }
    
    public void setErrors(final List<String> errors) {
        this.errors = errors;
    }
}

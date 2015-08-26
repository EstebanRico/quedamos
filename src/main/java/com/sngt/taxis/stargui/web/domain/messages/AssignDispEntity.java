package com.sngt.taxis.stargui.web.domain.messages;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

public class AssignDispEntity extends AbstractEntity
{
    @Documentation("Paiement")
    @JsonProperty("pmt")
    private String mPayment;
    @Documentation("Liste d'attributs")
    @JsonProperty("ats")
    private List<String> mAttributes;
    @Documentation("Liste de courses")
    @JsonProperty("crs")
    private List<Course> mCourses;
    @JsonIgnore
    private boolean mRestNoLoad;
    
    public AssignDispEntity() {
        super(MQMessageType.ASSIGN_DISP.getType());
    }
    
    public void initEg() {
        this.mPayment = "CB";
        this.mAttributes = Arrays.asList("foo", "bar", "baz");
        final Course course = new Course();
        course.initEg();
        (this.mCourses = new ArrayList<Course>()).add(course);
    }
    
    public String getPayment() {
        return this.mPayment;
    }
    
    public void setPayment(final String payment) {
        this.mPayment = payment;
    }
    
    public List<String> getAttributes() {
        if (this.mAttributes == null) {
            this.mAttributes = new ArrayList<String>();
        }
        return this.mAttributes;
    }
    
    public void setAttributes(final List<String> attributes) {
        this.mAttributes = attributes;
    }
    
    public boolean isRestNoLoad() {
        return this.mRestNoLoad;
    }
    
    public void setRestNoLoad(final boolean restNoLoad) {
        this.mRestNoLoad = restNoLoad;
    }
    
    public List<Course> getCourses() {
        if (this.mCourses == null) {
            this.mCourses = new ArrayList<Course>();
        }
        return this.mCourses;
    }
    
    public boolean isWeCab() {
        return this.mCourses != null && this.mCourses.size() > 1;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final Course course : this.getCourses()) {
            sb.append(course.toString()).append("\n");
        }
        return "{mPayment='" + this.mPayment + '\'' + ", mAttributes=" + this.mAttributes + ", mCourses=" + sb.toString() + ", mRestNoLoad=" + this.mRestNoLoad + '}';
    }
}

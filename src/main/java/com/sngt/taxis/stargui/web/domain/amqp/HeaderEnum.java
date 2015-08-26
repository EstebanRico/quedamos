package com.sngt.taxis.stargui.web.domain.amqp;

public enum HeaderEnum
{
    SIZE("SIZE", 3), 
    MID("MID", 5), 
    PACKID("ID", 2), 
    TYPE("TYPE", 4), 
    RESP("RESP", 2);
    
    private String name;
    private int charNumber;
    
    private HeaderEnum(final String name, final int charNumber) {
        this.name = name;
        this.charNumber = charNumber;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public int getCharNumber() {
        return this.charNumber;
    }
    
    public static int getHeaderCharNumber() {
        int total = 0;
        for (final HeaderEnum element : values()) {
            total += element.getCharNumber();
        }
        return total;
    }
}

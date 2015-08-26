package com.sngt.taxis.stargui.web.domain.messages;

public class BookOffEntity extends AbstractEntity
{
    private static final long serialVersionUID = -1941099963358828686L;
    
    public BookOffEntity() {
        super(MQMessageType.BOOK_OFF.getType());
    }
    
    public void initEg() {
    }
    
    public String toString() {
        return " [Sortie de zone]";
    }
}

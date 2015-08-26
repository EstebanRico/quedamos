package com.sngt.taxis.stargui.web.domain.messages;

public class AbandonCourseEntity extends AbstractEntityWithCommonPart
{
    public AbandonCourseEntity() {
        super(MQMessageType.ABANDON_COURSE.getType());
    }
    
    public AbandonCourseEntity(final Geolocation geolocation, final char taximeterState, final Integer time) {
        super(MQMessageType.ABANDON_COURSE.getType(), geolocation, taximeterState, time);
    }
}

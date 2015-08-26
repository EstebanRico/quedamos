package com.sngt.taxis.stargui.web.domain.messages;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Documentation {
    String value();
    
    String comment() default "";
}

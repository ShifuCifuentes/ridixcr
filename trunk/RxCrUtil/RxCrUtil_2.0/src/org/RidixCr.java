package org;
import java.lang.annotation.*;
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface RidixCr {    
    public abstract String author();
}

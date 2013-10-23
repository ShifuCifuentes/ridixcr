package org.sysconpat.rx;
import java.lang.annotation.*;
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface SysConPat {    
    public abstract String author();
}

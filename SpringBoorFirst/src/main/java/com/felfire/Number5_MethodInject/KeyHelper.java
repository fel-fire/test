package com.felfire.Number5_MethodInject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("keyHelper")
@Scope("prototype")
public class KeyHelper {
    public void open() {
        //System.out.println(this.toString() + ": try to open"+ Math.random());
    }
}

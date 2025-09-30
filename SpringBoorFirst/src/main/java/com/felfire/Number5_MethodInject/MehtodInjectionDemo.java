package com.felfire.Number5_MethodInject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MehtodInjectionDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(LookupConfig.class);

        var opener = ctx.getBean("standartLockOpener",LockOpener.class);
        opener.openLock();
        var opener1 = ctx.getBean("standartLockOpener",LockOpener.class);
        opener1.openLock();
        var opener2 = ctx.getBean("abstractLockOpener", LockOpener.class);
        opener2.openLock();
        var opener3 = ctx.getBean("abstractLockOpener", LockOpener.class);
        opener3.openLock();
        
    }
}

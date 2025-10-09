package com.felfire.Number5_MethodInject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;

public class MehtodInjectionDemo {
    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(LookupConfig.class);
        var abstractLockOpener = ctx.getBean("abstractLockOpener", LockOpener.class);
        var standardLockOpener = ctx.getBean("standartLockOpener", LockOpener.class);
        displayInfo("abstractLockOpener", abstractLockOpener);
        displayInfo("standartLockOpener", standardLockOpener);
    }

    public static void displayInfo(String beanName, LockOpener lockOpener) {
        KeyHelper keyHelperOne = lockOpener.getKeyOpener();
        KeyHelper keyHelperTwo = lockOpener.getKeyOpener();
        System.out.println("[" + beanName + "]: KeyHelper Instances the Same? " + (keyHelperOne == keyHelperTwo));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int x = 0; x < 100_000; x++) {
            KeyHelper keyHelper = lockOpener.getKeyOpener();
            keyHelper.open();
        }
        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }

}

package com.felfire.Chapter3.autowiring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiringDemo {
    private static Logger logger = LoggerFactory.getLogger(AutowiringDemo.class);
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(AutowiringCfg.class);

        var target = ctx.getBean(Target.class);
        logger.info("Created target? {}", target != null);
        logger.info("Injected Bar? {}", target.bar != null);
        logger.info("Injected FooOne? {}", target.fooOne != null ? target.fooOne.id : "nein");
        logger.info("Injected FooOne? {}", target.fooTwo != null ? target.fooTwo.id : "nein");

    }
}

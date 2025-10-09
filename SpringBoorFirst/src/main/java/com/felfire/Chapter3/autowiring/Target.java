package com.felfire.Chapter3.autowiring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Target {
    
    private static Logger logger = LoggerFactory.getLogger(Target.class);
    Foo fooOne;
    Foo fooTwo;
    Bar bar;

    public Target() {
        logger.info("---> Target() called");
    }
    
  
    public Target(Foo foo) {
        this.fooOne = foo;
        logger.info("---> Target(Foo foo) called");
    }
    @Autowired
    public Target(Foo foo, Bar bar) {
        this.fooOne = foo;
        this.bar = bar;
        logger.info("---> Target(Foo foo, Bar bar) called");
    }
}

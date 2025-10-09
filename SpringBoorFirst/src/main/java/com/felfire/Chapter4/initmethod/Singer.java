package com.felfire.Chapter4.initmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Singer {
    private static Logger logger = LoggerFactory.getLogger(Singer.class);

    private final String DEFAULT_NAME = "No name";
    private String name;
    private int age;

    public void setName(String name) {
        logger.info("Calling setName for bean of type {}", Singer.class);
        this.name = name;
    }

    public void setAge(int age ) {
        logger.info("Calling setAge for bean of type {}", Singer.class);
        this.age = age;
    }

    public void init() {
        logger.info("Initializing bean");
        if (name == null) {
            logger.info("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == 0) {
            throw new IllegalArgumentException("You must set the age property of any beans of type " + Singer.class);
        }
    }

    public String toString() {
        return "name = " + name + ";   age = " + age;
    }
}

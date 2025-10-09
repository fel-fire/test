package com.felfire.Chapter4.initmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitMethodDemo {
    
    private static Logger logger = LoggerFactory.getLogger(InitMethodDemo.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SingerConfiguration.class);

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);
    }

    public static Singer getBean(String beanName, ApplicationContext ctx) {
        try {
            Singer bean = ctx.getBean(beanName, Singer.class);
            logger.info("Found: {}", bean);
            return bean;
        } catch (BeanCreationException e) {
            logger.error("Ann error occurred in bean configuration" + e.getMessage());
            return null;
        }
    }
}

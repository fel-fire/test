package com.felfire.SpringBoorFirst;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpringAnnotated {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        System.out.println("""
            ---------------------------------------------------------------------------
            ------------------Application HelloWorldSpring is launched!----------------
            ---------------------------------------------------------------------------
                    """);
        MessageRenderer mr = context.getBean("renderer", StandardOutMessageRenderer.class);
        mr.render();

    }

}

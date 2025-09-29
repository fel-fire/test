package com.felfire.Valinject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component("injectSimpleSpEL")
public class InjectSimpleSpELDemo {
    @Value("#{injectSimpleConfig.name.toUpperCase()}")
    private String name;
    @Value("#{injectSimpleConfig.age+1}")
    private int age;
    @Value("#{injectSimpleConfig.height}")
    private float height;
    @Value("#{injectSimpleConfig.developer}")
    private boolean developer;
    @Value("#{injectSimpleConfig.ageInSeconds}")
    private Long ageInSeconds;

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(InjectSimpleConfig.class, InjectSimpleSpELDemo.class);
        ctx.refresh();

        InjectSimpleSpELDemo demo = (InjectSimpleSpELDemo) ctx.getBean("injectSimpleSpEL");
        System.out.println(demo);
    }

    public String toString() {
        return "Name: " + name + "\n"
            + "Age: " + age + "\n"
            + "Age in Seconds: " + ageInSeconds + "\n"
            + "Height: " + height + "\n"
            + "Is Developer?: " + developer;
    }
    
}

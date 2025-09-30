package com.felfire.Number4_ListInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollectionInjectionDemo {
    
    public static void main(String[] args) {
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(CollectionConfig.class, CollectionBean.class);
        
        var collectingBean = ctx.getBean(CollectionBean.class);
        collectingBean.printCollections();
    }
}

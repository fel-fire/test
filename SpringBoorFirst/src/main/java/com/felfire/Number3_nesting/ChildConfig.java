package com.felfire.Number3_nesting;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChildConfig implements ApplicationContextAware {

    public ApplicationContext context;

    @Bean
    TitleProvider childProvider() {
        return TitleProvider.instatnce("No such Thing");
    }

    @Bean
    Song song1(@Value("#{parentProvider.title}") String title) {
        return new Song(title);
    } 

    @Bean 
    Song song2(@Value("#{childConfig.context.parent.getBean(\"childProvider\").title}") String title) {
        return new Song(title);
    }

    @Bean
    Song song3(@Value("#{childProvider.title}") String title){
        return new Song(title);
}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        
    }
    
    
}

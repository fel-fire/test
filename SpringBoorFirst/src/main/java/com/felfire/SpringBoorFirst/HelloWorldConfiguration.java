package com.felfire.SpringBoorFirst;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class HelloWorldConfiguration {
    
    @Bean
    public MessageProvider messageProvider() {
        return new HelloWorldMessageProvider();
    }

    // @Bean
    // public MessageRenderer messageRenderer() {
    //     MessageRenderer messageRenderer = new StandardOutMessageRenderer();
    //     messageRenderer.setMessageProvider(messageProvider());
    //     return messageRenderer;
    // }
}

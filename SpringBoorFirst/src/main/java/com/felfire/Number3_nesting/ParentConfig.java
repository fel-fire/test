package com.felfire.Number3_nesting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParentConfig {
    
    @Bean
    public TitleProvider parentProvider() {
        return TitleProvider.instatnce(null);
    }

    @Bean
    public TitleProvider childProvider() {
        return TitleProvider.instatnce("Daugters");
    }
}

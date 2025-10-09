package com.felfire.Chapter3.naming;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(nameGenerator = SimpleBeanNameGenerator.class)
public class BeanNamingCfg {
    
}

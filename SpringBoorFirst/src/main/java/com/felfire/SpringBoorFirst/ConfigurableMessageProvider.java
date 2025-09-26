package com.felfire.SpringBoorFirst;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("provider2")
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    public ConfigurableMessageProvider(@Value("This is default ConfigurableMessageProvider message!") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
    
}

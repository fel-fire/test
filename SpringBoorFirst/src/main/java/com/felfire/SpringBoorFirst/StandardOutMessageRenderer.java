package com.felfire.SpringBoorFirst;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("renderer")
public class StandardOutMessageRenderer implements MessageRenderer{

    private MessageProvider messageProvider;

    public StandardOutMessageRenderer(@Qualifier("provider2") MessageProvider messageProvider) {
        System.out.println(" --> StandardOutMessageRenderer: constructor called");
        this.messageProvider = messageProvider;
        System.out.println(" --> StandardOutMessageRenderer: Injecting dependency using constructor");
    }

    @Override
    public void render() {
        if (messageProvider == null) throw new RuntimeException("Message Provider is null");
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
        System.out.println(" --> StandardOutMessageRenderer: setting the provider");
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

}

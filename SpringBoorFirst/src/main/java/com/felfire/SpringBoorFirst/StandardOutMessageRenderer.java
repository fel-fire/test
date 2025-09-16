package com.felfire.SpringBoorFirst;

public class StandardOutMessageRenderer implements MessageRenderer{

    private MessageProvider messageProvider;

    public StandardOutMessageRenderer() {
        System.out.println(" --> StandardOutMessageRenderer: constructor called");
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

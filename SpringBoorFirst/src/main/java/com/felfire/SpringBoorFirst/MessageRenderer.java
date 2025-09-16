package com.felfire.SpringBoorFirst;

public interface MessageRenderer {

    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}

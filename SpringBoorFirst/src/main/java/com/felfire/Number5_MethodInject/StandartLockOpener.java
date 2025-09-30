package com.felfire.Number5_MethodInject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("standartLockOpener")
public class StandartLockOpener implements LockOpener{
    
    private KeyHelper keyHelper;

    @Autowired
    @Qualifier("keyHelper")
    public void setKeyHelper(KeyHelper keyHelper) {
        this.keyHelper = keyHelper;
    }

    @Override
    public KeyHelper getKeyOpener() {
        return keyHelper;
    }

    @Override
    public void openLock() {
        keyHelper.open();
    }
    
}

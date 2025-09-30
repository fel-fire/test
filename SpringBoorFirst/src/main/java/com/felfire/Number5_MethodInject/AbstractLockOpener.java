package com.felfire.Number5_MethodInject;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("abstractLockOpener")
abstract class AbstractLockOpener implements LockOpener {


    @Lookup("keyHelper")
    @Override
    public abstract KeyHelper getKeyOpener();
    

    @Override
    public void openLock() {
        getKeyOpener().open();;
    }
    
}

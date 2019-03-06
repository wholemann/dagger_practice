package com.example.wholeman.daggerpractice.withdagger;

import javax.inject.Inject;

class GuatemalaBean extends CoffeeBean {
    @Inject
    public GuatemalaBean(){
        super();
    }

    public void name(){
        System.out.println("GuatemalaBean");
    }
}

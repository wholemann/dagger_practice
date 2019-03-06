package com.example.wholeman.daggerpractice.withdagger;

import javax.inject.Inject;

public class CoffeeMaker {

    private Heater heater;

    @Inject
    public CoffeeMaker(Heater heater) {
        this.heater = heater;
    }

    public void brew(CoffeeBean coffeeBean) {
        System.out.println("CoffeeBean("+coffeeBean.toString()+") [_]P coffee! [_]P ");
    }
}

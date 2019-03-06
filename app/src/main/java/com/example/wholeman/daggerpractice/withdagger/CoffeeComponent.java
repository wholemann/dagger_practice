package com.example.wholeman.daggerpractice.withdagger;

import java.util.Map;

import dagger.Component;
import dagger.Subcomponent;

@CoffeeScope
@Subcomponent(modules = {
        CoffeeModule.class,
        CoffeeBeanModule.class
})
public interface CoffeeComponent {
    CoffeeMaker coffeeMaker();
    CoffeeBean coffeeBean();
    Map<String,CoffeeBean> coffeeBeanMap();

    @Subcomponent.Builder
    interface Builder {
        Builder coffeeMudole(CoffeeModule coffeeModule);
        CoffeeComponent build();
    }

}

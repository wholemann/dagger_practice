package com.example.wholeman.daggerpractice.withdagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        CafeModule.class
})
public interface CafeComponent {
    CafeInfo cafeInfo();
    CoffeeComponent.Builder coffeeComponent();

    @Component.Builder
    interface Builder {
        Builder cafeModule(CafeModule cafeModule);
        CafeComponent build();
    }
}

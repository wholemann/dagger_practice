package com.example.wholeman.daggerpractice;

import com.example.wholeman.daggerpractice.withdagger.CafeComponent;
import com.example.wholeman.daggerpractice.withdagger.CafeInfo;
import com.example.wholeman.daggerpractice.withdagger.CafeModule;
import com.example.wholeman.daggerpractice.withdagger.CoffeeBean;
import com.example.wholeman.daggerpractice.withdagger.CoffeeComponent;
import com.example.wholeman.daggerpractice.withdagger.CoffeeMaker;
import com.example.wholeman.daggerpractice.withdagger.DaggerCafeComponent;

public class CafeApp {
    public static void main(String[] args) {
        {
            // Scope
            CafeComponent cafeComponent = DaggerCafeComponent.create();
            CafeInfo cafeInfo1 = cafeComponent.cafeInfo();
            CafeInfo cafeInfo2 = cafeComponent.cafeInfo();
            System.out.println("Singleton scope CafeInfo is equal : " + cafeInfo1.equals(cafeInfo2));

            // CoffeeScope
            CoffeeComponent coffeeComponent1 = cafeComponent.coffeeComponent().build();
            CoffeeComponent coffeeComponent2 = cafeComponent.coffeeComponent().build();
            CoffeeMaker coffeeMaker1 = coffeeComponent1.coffeeMaker();
            CoffeeMaker coffeeMaker2 = coffeeComponent1.coffeeMaker();
            System.out.println("Maker scope / same component coffeeMaker is equal : " + coffeeMaker1.equals(coffeeMaker2));
            CoffeeMaker coffeeMaker3 = coffeeComponent2.coffeeMaker();
            System.out.println("Maker scope / different component coffeeMaker is equal : " + coffeeMaker1.equals(coffeeMaker3));

            //Non-scope
            CoffeeBean coffeeBean1 = coffeeComponent1.coffeeBean();
            CoffeeBean coffeeBean2 = coffeeComponent1.coffeeBean();
            System.out.println("Non-scoped coffeebean is equal : " + coffeeBean1.equals(coffeeBean2));

            //Encapsulate
            //바로 CoffeeComponent 를 통해서 커피를 내릴수 없다.
            //CafeComponent 를 통해야만 CoffeeComponent에 접근 할 수 있다. 즉 카페 방문 없이 커피를 내리는 것을 방지 할 수 있다.
            CoffeeComponent coffeeComponent = DaggerCafeComponent.create().coffeeComponent().build();
            coffeeComponent.coffeeMaker().brew(coffeeComponent.coffeeBean());
        }

        //Builder 의 활용
        {
            CafeComponent cafeComponent = DaggerCafeComponent.builder()
                    .cafeModule(new CafeModule("example cafe"))
                    .build();
            cafeComponent.cafeInfo().welcome();
        }

        //IntoMap 활용
        {
            CoffeeComponent coffeeComponent = DaggerCafeComponent.create().coffeeComponent().build();
            coffeeComponent.coffeeBeanMap().get("guatemala").name();
        }

    }
}

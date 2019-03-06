package com.example.wholeman.daggerpractice.withoutdi;

public class A_Heater implements Heater {

    boolean heating;

    public A_Heater() {
    }

    @Override
    public void on() {
        System.out.println("A_Heater : ~~~ heating ~~~");
        this.heating = true;
    }

    @Override
    public void off() {
        this.heating = false;
    }

    @Override
    public boolean isHot() {
        return heating;
    }
}

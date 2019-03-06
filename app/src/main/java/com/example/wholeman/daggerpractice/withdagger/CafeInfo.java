package com.example.wholeman.daggerpractice.withdagger;

public class CafeInfo {

    private String name;

    public CafeInfo() {}

    public CafeInfo(String name) { this.name = name; }

    public void welcome() {
        System.out.println("Welcome " + name == null? "":name );
    }

}

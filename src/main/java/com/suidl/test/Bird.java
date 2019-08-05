package com.suidl.test;

@FunctionalInterface
public interface Bird {
    void fly();
    default String getName(){
        return "鸟";
    }
}

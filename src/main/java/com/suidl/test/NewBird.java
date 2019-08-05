package com.suidl.test;

public class NewBird extends BlackBird implements Bird {
    private String name;
    private int age;
    @Override
    public void fly() {
        System.out.println("fly");
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

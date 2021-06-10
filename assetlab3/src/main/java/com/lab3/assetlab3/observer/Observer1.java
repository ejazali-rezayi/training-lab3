package com.lab3.assetlab3.observer;

public class Observer1 implements Observer {

    @Override
    public void update(String m) {
        System.out.println("Observer1: " + m);
    }
}

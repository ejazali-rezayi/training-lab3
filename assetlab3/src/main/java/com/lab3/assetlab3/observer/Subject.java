package com.lab3.assetlab3.observer;

public interface Subject {
    public void attach(Observer o);

    public void detach(Observer o);

    public void notifyUpdate(String message);
}

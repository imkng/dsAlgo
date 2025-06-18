package com.company;

import java.util.ArrayList;
import java.util.List;

interface Subject{
    public void subscribed(Observer observer);
    public void unSubscribed(Observer observer);
    public void notifies(String str);
}

interface Observer{
    public void notified(String s);
}

class Subscriber implements Observer{

    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void notified(String s) {
        System.out.println(name + " Notified!!!!" + s);
    }
}

class YoutubeChannel implements Subject{

    List<Observer> observerList = new ArrayList<>();

    @Override
    public void subscribed(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unSubscribed(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifies(String s) {
        for (Observer observer: observerList){
            observer.notified(s);
        }
    }
}

public class ObserverDesign {
    public static void main(String[] args) {
        Observer observer = new Subscriber("Aman");
        Observer observer1 = new Subscriber("chaman");
        Subject subject = new YoutubeChannel();
        subject.subscribed(observer);
        subject.subscribed(observer1);
        subject.notifies("LLD!!");
        subject.notifies("HLD");
    }
}

package com.nexign.model.patterns;

public class Singleton extends Pattern {
    private static Singleton singleton;

    public Singleton() {
        this.setName("I'm a singleton!");
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

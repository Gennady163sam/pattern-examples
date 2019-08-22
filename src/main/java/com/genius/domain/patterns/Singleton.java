package com.genius.domain.patterns;

/**
 * This class implements Singleton pattern behavior
 *
 * @author  Gennady Savinov
 * @see     Pattern
 */
public class Singleton extends Pattern {
    private static Singleton singleton;

    /**
     * The key idea in this pattern is to make the class itself responsible for controlling its instantiation (that it is instantiated only once).
     * The hidden constructor (declared private) ensures that the class can never be instantiated from outside the class.
     * The public static operation can be accessed easily by using the class name and operation name (Singleton.getInstance()).
     */
    private Singleton() {
        this.setName("I'm a singleton!");
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

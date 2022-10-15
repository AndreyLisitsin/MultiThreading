package org.example;

public class FooFirstVersion {
    private boolean endFirst = false;
    private boolean endSecond = false;
    public synchronized void first(Runnable r){
        System.out.println("first");
        endFirst = true;
        notify();
    }
    public synchronized void second(Runnable r){
        while (!endFirst) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("second");
        endSecond = true;
        notify();
    }
    public synchronized void third(Runnable r){
        while (!endSecond) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("third");
    }
}

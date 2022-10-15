package org.example;

import java.util.concurrent.Semaphore;

public class Foo {
    private Semaphore semaphore = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(1);
    private Semaphore semaphore3 = new Semaphore(1);

    public Foo(){
        try {
            semaphore2.acquire(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            semaphore3.acquire(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void first(Runnable r) throws InterruptedException {
        semaphore.acquire();
        System.out.println("first");
        semaphore2.release(1);
    }
    public synchronized void second(Runnable r) throws InterruptedException {
        semaphore2.acquire();
        System.out.println("second");
        semaphore3.release(1);
    }
    public synchronized void third(Runnable r) throws InterruptedException {
        semaphore3.acquire();
        System.out.println("third");
        semaphore3.release();
    }
}

package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){

        FooFirstVersion foo1 = new FooFirstVersion();
        Foo foo = new Foo();

//        CompletableFuture.runAsync(() -> foo1.third(new Thread()));
//        CompletableFuture.runAsync(() -> foo1.second(new Thread()));
//        CompletableFuture.runAsync(() -> foo1.first(new Thread()));



            CompletableFuture.runAsync(() -> {
                try {
                    foo.third(new Thread());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            CompletableFuture.runAsync(() -> {
                try {
                    foo.second(new Thread());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            CompletableFuture.runAsync(() -> {
                try {
                    foo.first(new Thread());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });



    }
}
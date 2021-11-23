package com.seok2.core.singleton;

public final class SingletonService {

    private static final SingletonService INSTANCE = new SingletonService();


    private SingletonService() {

    }

    public static SingletonService getInstance() {
        return INSTANCE;
    }

    public void call() {
        System.out.println("call singleton service");
    }
}

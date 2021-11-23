package com.seok2.core.singleton;

public final class SingletonStatefulService {

    private static final SingletonStatefulService INSTANCE = new SingletonStatefulService();

    private int price;

    private SingletonStatefulService() {

    }

    public static SingletonStatefulService getInstance() {
        return INSTANCE;
    }

    public void order(String name, int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}

package com.example.logtracer.strategy;

public interface Strategy<T> {

    T call(String itemId);

}

package com.example.logtracer.strategy.delegation;

public interface DelegationStrategy<T> {
    T call(String itemId);
}

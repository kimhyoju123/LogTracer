package com.example.logtracer.strategy.delegation;

public class DelegationRepositoryLogic implements DelegationStrategy {

    @Override
    public Void call(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생!");
        }
        sleep(1000);
        return null;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

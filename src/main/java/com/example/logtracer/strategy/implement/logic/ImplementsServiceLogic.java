package com.example.logtracer.strategy.implement.logic;

import com.example.logtracer.strategy.Strategy;
import com.example.logtracer.strategy.implement.ImplementsOrderRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ImplementsServiceLogic implements Strategy {

    private final ImplementsOrderRepository implementsOrderRepository;

    @Override
    public Void call(String itemId) {
        implementsOrderRepository.save(itemId);
        return null;
    }
}

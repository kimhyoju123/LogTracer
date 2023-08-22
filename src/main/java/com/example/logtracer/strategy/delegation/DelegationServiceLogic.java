package com.example.logtracer.strategy.delegation;

import com.example.logtracer.strategy.basic.BasicStrategyOrderRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DelegationServiceLogic implements DelegationStrategy {

    private final BasicStrategyOrderRepository basicStrategyOrderRepository;

    @Override
    public Void call(String itemId) {
        basicStrategyOrderRepository.save(itemId);
        return null;
    }
}

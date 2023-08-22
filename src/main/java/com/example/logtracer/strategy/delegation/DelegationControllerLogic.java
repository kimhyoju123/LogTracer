package com.example.logtracer.strategy.delegation;

import com.example.logtracer.strategy.basic.BasicStrategyOrderService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DelegationControllerLogic implements DelegationStrategy {

    private final BasicStrategyOrderService basicStrategyOrderService;

    @Override
    public String call(String itemId) {
        basicStrategyOrderService.orderItem(itemId);
        return "ok";
    }
}

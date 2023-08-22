package com.example.logtracer.strategy.implement.logic;

import com.example.logtracer.strategy.Strategy;
import com.example.logtracer.strategy.implement.ImplementsOrderService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ImplementsControllerLogic implements Strategy {

    private final ImplementsOrderService implementsOrderService;

    @Override
    public String call(String itemId) {
        implementsOrderService.orderItem(itemId);
        return "ok";
    }
}

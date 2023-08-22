package com.example.logtracer.strategy.implement;

import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.Context;
import com.example.logtracer.strategy.Strategy;
import com.example.logtracer.strategy.implement.logic.ImplementsServiceLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImplementsOrderService {

    private final LogTrace trace;
    private final ImplementsOrderRepository implementsOrderRepository;

    public void orderItem(String itemId) {
        Strategy<Void> strategy = new ImplementsServiceLogic(implementsOrderRepository);
        Context<Void> context = new Context<>(trace, strategy);
        context.execute(itemId, "ImplementsOrderService.orderItem()");
    }

}
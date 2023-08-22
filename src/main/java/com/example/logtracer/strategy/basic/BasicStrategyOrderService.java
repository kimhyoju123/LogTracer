package com.example.logtracer.strategy.basic;

import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.Context;
import com.example.logtracer.strategy.Strategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasicStrategyOrderService {

    private final LogTrace trace;
    private final BasicStrategyOrderRepository basicStrategyOrderRepository;

    public void orderItem(String itemId) {

        Strategy<Void> strategy = (trace) -> {
            basicStrategyOrderRepository.save(itemId);
            return null;
        };

        Context<Void> context = new Context<>(trace, strategy);
        context.execute(itemId, "BasicStrategyOrderService.orderItem()");
    }

}
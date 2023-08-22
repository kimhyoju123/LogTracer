package com.example.logtracer.strategy.delegation;

import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.basic.BasicStrategyOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DelegationOrderService {

    private final LogTrace trace;
    private final BasicStrategyOrderRepository basicStrategyOrderRepository;

    public void orderItem(String itemId) {
        DelegationStrategy<Void> strategy = new DelegationServiceLogic(basicStrategyOrderRepository);
        DelegationContext<Void> context = new DelegationContext<>(trace, strategy);
        context.execute(itemId, "DelegationOrderService.orderItem()");
    }

}
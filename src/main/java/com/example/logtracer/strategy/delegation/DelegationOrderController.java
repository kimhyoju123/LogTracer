package com.example.logtracer.strategy.delegation;

import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.basic.BasicStrategyOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DelegationOrderController {

    private final LogTrace trace;
    private final BasicStrategyOrderService basicStrategyOrderService;

    @GetMapping("/strategy/delegation/request")
    public String request(String itemId) {
        DelegationStrategy<String> strategy = new DelegationControllerLogic(basicStrategyOrderService);
        DelegationContext<String> context = new DelegationContext<>(trace, strategy);
        return context.execute(itemId, "DelegationOrderController.request()");
    }

}
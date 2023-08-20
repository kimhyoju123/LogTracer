package com.example.logtracer.strategy.basic;

import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.Strategy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BasicStrategyOrderController {

    private final LogTrace trace;
    private final BasicStrategyOrderService basicStrategyOrderService;

    @GetMapping("/basic/strategy/request")
    public String request(String itemId) {
        Strategy<String> strategy = (trace) -> {
            basicStrategyOrderService.orderItem(itemId);
            return "ok";
        };

        BasicContext<String> context = new BasicContext<>(trace, strategy);
        return context.execute(itemId, "BasicStrategyOrderController.request()");
    }

}
package com.example.logtracer.strategy.implement;

import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.Strategy;
import com.example.logtracer.strategy.implement.logic.ImplementsControllerLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ImplementsOrderController {

    private final LogTrace trace;
    private final ImplementsOrderService implementsOrderService;

    @GetMapping("/strategy/implements/request")
    public String request(String itemId) {
        Strategy<String> strategy = new ImplementsControllerLogic(implementsOrderService);
        ImplementsContext<String> context = new ImplementsContext<>(trace, strategy);
        return context.execute(itemId, "ImplementsOrderController.request()");
    }

}
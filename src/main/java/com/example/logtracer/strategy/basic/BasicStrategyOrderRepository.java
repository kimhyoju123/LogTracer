package com.example.logtracer.strategy.basic;

import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.Context;
import com.example.logtracer.strategy.Strategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BasicStrategyOrderRepository {

    private final LogTrace trace;

    public void save(String itemId) {
        Strategy<Void> strategy = (trace) -> {
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            return null;
        };

        Context<Void> context = new Context<>(trace, strategy);
        context.execute(itemId, "BasicStrategyOrderRepository.save()");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

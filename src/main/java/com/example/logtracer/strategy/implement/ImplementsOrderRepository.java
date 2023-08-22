package com.example.logtracer.strategy.implement;

import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.Context;
import com.example.logtracer.strategy.Strategy;
import com.example.logtracer.strategy.implement.logic.ImplementsRepositoryLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ImplementsOrderRepository {

    private final LogTrace trace;

    public void save(String itemId) {
        Strategy<Void> strategy = new ImplementsRepositoryLogic();
        Context<Void> context = new Context<>(trace, strategy);
        context.execute(itemId, "ImplementsOrderRepository.save()");
    }
}
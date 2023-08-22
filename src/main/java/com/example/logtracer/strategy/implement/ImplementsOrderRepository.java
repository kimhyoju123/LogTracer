package com.example.logtracer.strategy.implement;

import com.example.logtracer.logtrace.LogTrace;
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
        ImplementsContext<Void> context = new ImplementsContext<>(trace, strategy);
        context.execute(itemId, "ImplementsOrderRepository.save()");
    }
}
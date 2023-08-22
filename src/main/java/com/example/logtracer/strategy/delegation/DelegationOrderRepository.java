package com.example.logtracer.strategy.delegation;

import com.example.logtracer.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DelegationOrderRepository {

    private final LogTrace trace;

    public void save(String itemId) {
        DelegationStrategy<Void> strategy = new DelegationRepositoryLogic();
        DelegationContext<Void> context = new DelegationContext<>(trace, strategy);
        context.execute(itemId, "BasicStrategyOrderRepository.save()");
    }
}
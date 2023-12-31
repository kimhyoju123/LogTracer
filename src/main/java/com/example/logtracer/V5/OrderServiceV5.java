package com.example.logtracer.V5;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {

    private final TraceTemplate template;
    private final OrderRepositoryV5 orderRepository;

    public void orderItem(String itemId) {
        template.execute("OrderServiceV5.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}

package com.example.logtracer.V5;

import com.example.logtracer.callback.TraceTemplate;
import com.example.logtracer.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public void save(String itemId) {
        template.execute("OrderRepositoryV5.save()", () -> {
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

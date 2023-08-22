package com.example.logtracer.strategy;

import com.example.logtracer.TraceStatus;
import com.example.logtracer.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

// Context 내부에 Strategy 필드를 가지고 있으며, 이 필드에 변하는 부분인 Strategy 의 구현체를 주입하면 된다.

@RequiredArgsConstructor
public class Context<T> {

    private final LogTrace logTrace;
    private final Strategy<T> strategy;

    public T execute(String itemId, String message) {
        TraceStatus status = null;
        try {
            status = logTrace.begin(message);

            // 로직 호출
            T result = strategy.call(itemId);

            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

}
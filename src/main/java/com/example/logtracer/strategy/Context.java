package com.example.logtracer.strategy;

import com.example.logtracer.TraceStatus;
import com.example.logtracer.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

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
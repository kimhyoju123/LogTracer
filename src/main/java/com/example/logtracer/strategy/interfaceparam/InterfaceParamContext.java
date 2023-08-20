package com.example.logtracer.strategy.interfaceparam;

import com.example.logtracer.TraceStatus;
import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.Strategy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InterfaceParamContext<T> {

    private final LogTrace logTrace;

    public T execute(String itemId, String message, Strategy<T> strategy) {
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
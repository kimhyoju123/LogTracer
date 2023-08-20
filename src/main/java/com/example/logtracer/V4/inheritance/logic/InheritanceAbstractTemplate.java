package com.example.logtracer.V4.inheritance.logic;

import com.example.logtracer.TraceStatus;
import com.example.logtracer.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class InheritanceAbstractTemplate<T> {

    private final LogTrace logTrace;

    public T execute(String itemId, String message) {
        TraceStatus status = null;
        try {
            status = logTrace.begin(message);

            // 로직 호출
            T result = call(itemId);

            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call(String itemId);

}

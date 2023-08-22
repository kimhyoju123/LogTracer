package com.example.logtracer.strategy.interfaceparam;

import com.example.logtracer.TraceStatus;
import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.Strategy;
import lombok.RequiredArgsConstructor;

// Strategy 를 필드가 아닌 파라미터로 전달받도록 한다.
// 클라이언트가 execute() 를 호출할 때 Strategy 를 파리미터로 전달받아서 설정된 Strategy 구현체로 로직을 실행한다.
// Context 를 실행하는 시점에 원하는 Strategy 를 전달할 수 있어 더 유연하다.

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
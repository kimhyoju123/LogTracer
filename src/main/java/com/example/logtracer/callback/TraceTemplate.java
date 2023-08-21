package com.example.logtracer.callback;

import com.example.logtracer.TraceStatus;
import com.example.logtracer.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// 전략패턴의 Context 에 해당하는 Template 이다.
// 의존성 주입을 위해 TraceTemplate 을 빈으로 등록한다.

@Component
@RequiredArgsConstructor
public class TraceTemplate {

    private final LogTrace trace;

    // 템플릿 메소드
    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            // 로직 호출
            T result = callback.call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; }
    }

}

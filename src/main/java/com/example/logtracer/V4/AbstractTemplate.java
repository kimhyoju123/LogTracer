package com.example.logtracer.V4;

import com.example.logtracer.TraceStatus;
import com.example.logtracer.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

// 추상 클래스로 부모 클래스를 생성하고, 템플릿 메소드와 추상 메소드를 선언한다.
// 익명 클래스로 구현할 때는 자식 클래스를 생성하지 않아도 된다. => V4

@RequiredArgsConstructor
public abstract class AbstractTemplate<T> {

    private final LogTrace logTrace;

    // 템플릿 메소드
    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = logTrace.begin(message);

            // 로직 호출
            T result = call();

            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();

}

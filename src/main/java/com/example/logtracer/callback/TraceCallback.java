package com.example.logtracer.callback;

// 콜백이란 코드를 넘겨준 곳의 뒤에서 실행된다는 것이다.
// 해당 인터페이스는 전략패턴의 Strategy 에 해당하는 Callback 이다.

public interface TraceCallback<T> {
    T call();
}

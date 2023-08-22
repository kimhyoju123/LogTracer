package com.example.logtracer.V4.extend;

import com.example.logtracer.TraceStatus;
import com.example.logtracer.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

// 추상 클래스로 부모 클래스를 생성하고, 템플릿 메소드와 추상 메소드를 선언한다.
// 자식 클래스에서 추상 메소드인 call 을 오버라이딩해서 구현한다.
/*
 Generic : 클래스 내부에서 타입을 지정하지 않고 사용자 호출에 의해 타입이 지정됨(객체 생성 시점에 타입 결정)
           특정 타입에 종속되지 않는다.
           기본 타입(boolean, char, byte, short, int, long, float, double), void 는 타입으로 선언할 수 없다.
           기본 타입을 객체 타입으로 사용하는 Wrapper 클래스(Integer, Boolean ...)를 타입으로 사용해야한다.
   타입 인자 (일반적으로 사용하는 타입 인자, 지정된 것이 아니기 때문에 아무거나 사용 가능)
      <T> : 참조 타입
      <E> : 요소
      <K> : 키
      <V> : 값
      <N> : 숫자
*/

@RequiredArgsConstructor
public abstract class ExtendsAbstractTemplate<T> {

    private final LogTrace logTrace;

    // 템플릿 메소드
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

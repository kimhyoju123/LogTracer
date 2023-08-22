package com.example.logtracer.strategy;

// 전략패턴은 변하지 않는 부분을 Context 라는 클래스에 두고, 변하는 부분을 Strategy 인터페이스를 활용해서 구현하도록 한다.
// 상속이 아니라 위임으로 템플릿 메소드 패턴의 단점을 해결한다.
// Context 는 Strategy 인터페이스에만 의존하기 때문에 Strategy 의 구현체를 변경하거나 새로 만들어도 Context 코드는 변경되지 않는다.

// 전략 패턴에는 Strategy 인터페이스를 Context 클래스의 필드로 가지는 방법과 전략을 선택하는 메소드(execute())의 파라미터로 Strategy 를 주입하는 방법이 있다.
// 첫 번째 방법은 Context 객체를 생성하면서 Strategy 구현체를 주입받으며, Context 의 내부 구현체가 불변일 때 유용하다.
//   단점은 내부 구현체를 변경해야 할 때, 외부 객체가 싱글톤일 경우 동시성 문제 등 고려할 사항이 많고,
//         다른 전략을 사용하려면 다른 Strategy 구현체를 주입받은 새로운 Context 객체를 생성해야 한다.
//   스프링에서 애플리케이션 로딩 시점에 의존성 주입을 하는 것과 동일한 방식이다. (선 조립, 후 실행)
// 두 번째 방법은 Strategy 구현체를 Context 생성 시점이 아니라 execute() 호출 시점마다 결정할 수 있다. (유연함, 내부 구현체가 자주 변경되는 경우에 유용함)

public interface Strategy<T> {

    T call(String itemId);

}

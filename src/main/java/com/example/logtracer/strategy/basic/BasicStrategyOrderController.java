package com.example.logtracer.strategy.basic;

import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.Context;
import com.example.logtracer.strategy.Strategy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 람다를 활용해서 Strategy 구현체를 작성한다. (구현 클래스, 익명 클래스로도 가능)
// Strategy 구현체를 Context 에 주입한다.
// execute() 를 호출해서 Context 를 실행한다.
// 람다를 활용하려면 인터페이스에 메소드가 1개만 있으면 된다.
// 만약 다른 Strategy 구현체를 정의해야 하는 경우 Context 객체를 새로 만들어야 한다.
//      더 유연하게 전략 패턴 사용하는 방법 : 인터페이스를 파라미터 가지는 방법 => InterfaceParamContext

@RestController
@RequiredArgsConstructor
public class BasicStrategyOrderController {

    private final LogTrace trace;
    private final BasicStrategyOrderService basicStrategyOrderService;

    @GetMapping("/strategy/basic/request")
    public String request(String itemId) {
        Strategy<String> strategy = (trace) -> {
            basicStrategyOrderService.orderItem(itemId);
            return "ok";
        };

        Context<String> context = new Context<>(trace, strategy);
        return context.execute(itemId, "BasicStrategyOrderController.request()");
    }

}
package com.example.logtracer.strategy.interfaceparam;

import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.Strategy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 람다를 활용해서 Strategy 구현체를 execute()의 파라미터로 넘긴다.
// 다른 Strategy 구현체를 사용해야 할 때 Context 객체를 더 생성할 필요가 없다.
// 람다 표현식 내에서 외부 변수와 이름이 중복된 변수를 사용하면 변수 Scope 관련 문제가 발생할 수 있기 때문에 다른 변수 이름을 사용해야 한다.
// 템플릿 콜백 패턴도 이와 비슷한 방식으로 구현된다. => TraceCallback

@RestController
@RequiredArgsConstructor
public class InterfaceParamOrderController {

    private final LogTrace trace;
    private final InterfaceParamOrderService interfaceParamOrderService;

    @GetMapping("/interfaceparam/strategy/request")
    public String request(String itemId) {

        InterfaceParamContext<String> context = new InterfaceParamContext<>(trace);

//        익명 클래스 활용
//        return context.execute(itemId, "InterfaceParamOrderController.request()", new Strategy<String>() {
//            @Override
//            public String changeLogic(String itemId) {
//                interfaceParamOrderService.orderItem(itemId);
//                return "ok";
//            }
//        });

        // 람다 활용
        return context.execute(itemId, "InterfaceParamOrderController.request()", (paramItemId) -> {
            interfaceParamOrderService.orderItem(paramItemId);
            return "ok";
        });
    }

}
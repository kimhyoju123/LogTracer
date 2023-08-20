package com.example.logtracer.strategy.interfaceparam;

import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.Strategy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
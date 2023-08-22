package com.example.logtracer.strategy.interfaceparam;

import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.InterfaceParamContext;
import com.example.logtracer.strategy.basic.BasicStrategyOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterfaceParamOrderService {

    private final LogTrace trace;
    private final BasicStrategyOrderRepository basicStrategyOrderRepository;

    public void orderItem(String itemId) {

        InterfaceParamContext<Void> context = new InterfaceParamContext<>(trace);

//        익명 클래스 활용
//        context.execute(itemId, "InterfaceParamOrderService.orderItem()", new Strategy<Void>() {
//            @Override
//            public Void changeLogic(String itemId) {
//                basicStrategyOrderRepository.save(itemId);
//                return null;
//            }
//        });

        // 람다 활용
        context.execute(itemId, "InterfaceParamOrderService.orderItem()", (test) -> {
            basicStrategyOrderRepository.save(itemId);
            return null;
        });

    }

}
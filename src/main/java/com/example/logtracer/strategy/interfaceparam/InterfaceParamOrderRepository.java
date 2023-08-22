package com.example.logtracer.strategy.interfaceparam;

import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.strategy.InterfaceParamContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InterfaceParamOrderRepository {

    private final LogTrace trace;

    public void save(String itemId) {

        InterfaceParamContext<Void> context = new InterfaceParamContext<>(trace);

//        익명 클래스 활용
//        context.execute(itemId, "InterfaceParamOrderRepository.save()", new Strategy<Void>() {
//            @Override
//            public Void changeLogic(String itemId) {
//                if (itemId.equals("ex")) {
//                    throw new IllegalStateException("예외 발생!");
//                }
//                sleep(1000);
//                return null;
//            }
//        });

        // 람다 활용
        context.execute(itemId, "InterfaceParamOrderRepository.save()", (test) -> {
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            return null;
        });

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
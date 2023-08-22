package com.example.logtracer.V3;

import com.example.logtracer.TraceStatus;
import com.example.logtracer.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 핵심 로직인 2줄을 제외한 나머지 공통 기능 코드가 계속 중복되고 있다.
// 공통 기능이 변경되면 모든 클래스를 수정해야 하고, 메소드로 빼기도 어렵다.
// 템플릿 메소드 패턴을 적용하여 공통 로직을 따로 관리하도록 한다. => ExtendsAbstractTemplate

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");

            // 핵심 로직
            orderService.orderItem(itemId);

            trace.end(status);

            // 핵심 로직
            return "ok";
        } catch (Exception e) { trace.exception(status, e);
            throw e; //예외를 꼭 다시 던져주어야 한다.
        }
    }

}

package com.example.logtracer.V4;

import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final LogTrace trace;
    private final OrderServiceV4 orderService;

    @GetMapping("/v4/request")
    public String request(String itemId) {
        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        };

        // 템플릿 메소드 호출
        return template.execute("OrderControllerV4.request()");
    }

}

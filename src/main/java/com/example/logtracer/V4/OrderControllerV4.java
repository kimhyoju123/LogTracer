package com.example.logtracer.V4;

import com.example.logtracer.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 익명 클래스로 추상 메소드를 오버라이딩해서 핵심 로직을 구현하고, 템플릿 메소드를 호출하면 된다.
// 템플릿 메소드 패턴의 단점은 상속을 활용하기 때문에 부모, 자식 클래스간의 결합도가 증가한다.
// 이러한 단점을 보완할 수 있는 패턴이 전략 패턴이다. => Strategy

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

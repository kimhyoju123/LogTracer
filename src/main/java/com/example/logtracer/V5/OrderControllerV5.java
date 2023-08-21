package com.example.logtracer.V5;

import com.example.logtracer.callback.TraceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 템플릿 메소드를 실행하면서 콜백을 람다로 전달한다.
// 공통 처리인 템플릿 메서드를 따로 빼서 관리할 수 있게 되었지만, 여전히 공통 처리를 위해 모든 클래스에 수정이 필요하다. => 프록시 패턴으로 해결
//   - 모든 클래스에 Template 클래스 주입
//   - Template.execute() 호출
//   - execute 의 파라미터로 Callback 인터페이스를 오버라이딩한 객체를 넘겨줘야함.

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.execute("OrderControllerV5.request()", () -> {
            orderService.orderItem(itemId);
            return "ok";
        });
    }
}

package com.example.logtracer.V4.inheritance;

import com.example.logtracer.V4.inheritance.logic.ControllerLogic;
import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.template.InheritanceAbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 오버라이딩한 자식 클래스를 인스턴스로 생성하고, 템플릿 메소드를 호출한다.
// 자식 클래스를 각각 생성해서 이 코드와 같이 인스턴스로 사용할 수 있다.
// 하지만, 자식 클래스를 재사용할 것이 아니라면 익명 클래스를 활용해서 일회성 자식 클래스를 생성하는 것이 간단하다. => AbstractTemplate
// 부모 클래스가 인터페이스가 아니기 때문에 람다는 불가능하다.

@RestController
@RequiredArgsConstructor
public class InheritanceOrderControllerV4 {

    private final LogTrace trace;
    private final InheritanceOrderServiceV4 inheritanceOrderServiceV4;

    @GetMapping("/v4/inheritance/request")
    public String request(String itemId) {
        InheritanceAbstractTemplate<String> template = new ControllerLogic(trace, inheritanceOrderServiceV4);
        return template.execute(itemId, "OrderControllerV4.request()");
    }

}
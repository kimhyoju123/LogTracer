package com.example.logtracer.V4.inheritance;

import com.example.logtracer.V4.inheritance.logic.ControllerLogic;
import com.example.logtracer.V4.inheritance.logic.InheritanceAbstractTemplate;
import com.example.logtracer.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


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
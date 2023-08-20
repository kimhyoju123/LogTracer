package com.example.logtracer.V4.inheritance;

import com.example.logtracer.V4.inheritance.logic.InheritanceAbstractTemplate;
import com.example.logtracer.V4.inheritance.logic.ServiceLogic;
import com.example.logtracer.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InheritanceOrderServiceV4 {

    private final LogTrace trace;
    private final InheritanceOrderRepositoryV4 inheritanceOrderRepositoryV4;

    public void orderItem(String itemId) {
        InheritanceAbstractTemplate<Void> template = new ServiceLogic(trace, inheritanceOrderRepositoryV4);
        template.execute(itemId, "OrderServiceV4.orderItem()");
    }

}
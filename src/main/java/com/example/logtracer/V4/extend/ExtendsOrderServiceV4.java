package com.example.logtracer.V4.extend;

import com.example.logtracer.V4.extend.logic.ExtendsAbstractTemplate;
import com.example.logtracer.V4.extend.logic.ServiceLogic;
import com.example.logtracer.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExtendsOrderServiceV4 {

    private final LogTrace trace;
    private final ExtendsOrderRepositoryV4 extendsOrderRepositoryV4;

    public void orderItem(String itemId) {
        ExtendsAbstractTemplate<Void> template = new ServiceLogic(trace, extendsOrderRepositoryV4);
        template.execute(itemId, "ExtendsOrderServiceV4.orderItem()");
    }

}
package com.example.logtracer.V4.extend.logic;

import com.example.logtracer.V4.extend.ExtendsAbstractTemplate;
import com.example.logtracer.V4.extend.ExtendsOrderRepositoryV4;
import com.example.logtracer.logtrace.LogTrace;

public class ServiceLogic extends ExtendsAbstractTemplate<Void> {

    private final ExtendsOrderRepositoryV4 extendsOrderRepositoryV4;

    public ServiceLogic(LogTrace logTrace, ExtendsOrderRepositoryV4 extendsOrderRepositoryV4) {
        super(logTrace);
        this.extendsOrderRepositoryV4 = extendsOrderRepositoryV4;
    }

    @Override
    protected Void call(String itemId) {
        // 핵심 로직
        extendsOrderRepositoryV4.save(itemId);
        return null;
    }

}

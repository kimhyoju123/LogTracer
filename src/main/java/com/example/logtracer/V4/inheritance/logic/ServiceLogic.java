package com.example.logtracer.V4.inheritance.logic;

import com.example.logtracer.V4.inheritance.InheritanceOrderRepositoryV4;
import com.example.logtracer.logtrace.LogTrace;

public class ServiceLogic extends InheritanceAbstractTemplate<Void> {

    private final InheritanceOrderRepositoryV4 inheritanceOrderRepositoryV4;

    public ServiceLogic(LogTrace logTrace, InheritanceOrderRepositoryV4 inheritanceOrderRepositoryV4) {
        super(logTrace);
        this.inheritanceOrderRepositoryV4 = inheritanceOrderRepositoryV4;
    }

    @Override
    protected Void call(String itemId) {
        // 핵심 로직
        inheritanceOrderRepositoryV4.save(itemId);
        return null;
    }

}

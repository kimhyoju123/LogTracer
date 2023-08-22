package com.example.logtracer.V4.inheritance.logic;

import com.example.logtracer.V4.inheritance.InheritanceOrderServiceV4;
import com.example.logtracer.logtrace.LogTrace;

// 부모 클래스인 추상 클래스를 상속받고 추상 메소드를 오버라이딩해서 핵심 로직을 구현한다.

public class ControllerLogic extends InheritanceAbstractTemplate<String> {

    private final InheritanceOrderServiceV4 inheritanceOrderServiceV4;

    public ControllerLogic(LogTrace logTrace, InheritanceOrderServiceV4 inheritanceOrderServiceV4) {
        super(logTrace);
        this.inheritanceOrderServiceV4 = inheritanceOrderServiceV4;
    }

    @Override
    protected String call(String itemId) {
        // 핵심 로직
        inheritanceOrderServiceV4.orderItem(itemId);
        return "ok";
    }

}

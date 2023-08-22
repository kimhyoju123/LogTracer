package com.example.logtracer.V4.extend.logic;

import com.example.logtracer.V4.extend.ExtendsAbstractTemplate;
import com.example.logtracer.V4.extend.ExtendsOrderServiceV4;
import com.example.logtracer.logtrace.LogTrace;

// 부모 클래스인 추상 클래스를 상속받고 추상 메소드를 오버라이딩해서 핵심 로직을 구현한다.

public class ControllerLogic extends ExtendsAbstractTemplate<String> {

    private final ExtendsOrderServiceV4 extendsOrderServiceV4;

    public ControllerLogic(LogTrace logTrace, ExtendsOrderServiceV4 extendsOrderServiceV4) {
        super(logTrace);
        this.extendsOrderServiceV4 = extendsOrderServiceV4;
    }

    @Override
    protected String call(String itemId) {
        // 핵심 로직
        extendsOrderServiceV4.orderItem(itemId);
        return "ok";
    }

}

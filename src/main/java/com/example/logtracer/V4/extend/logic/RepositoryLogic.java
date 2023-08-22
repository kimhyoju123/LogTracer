package com.example.logtracer.V4.extend.logic;

import com.example.logtracer.V4.extend.ExtendsAbstractTemplate;
import com.example.logtracer.logtrace.LogTrace;

public class RepositoryLogic extends ExtendsAbstractTemplate<Void> {

    public RepositoryLogic(LogTrace logTrace) {
        super(logTrace);
    }

    @Override
    protected Void call(String itemId) {
        // 핵심 로직
        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생!");
        }
        sleep(1000);
        return null;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

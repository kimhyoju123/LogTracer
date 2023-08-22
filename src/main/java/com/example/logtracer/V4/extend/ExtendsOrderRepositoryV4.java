package com.example.logtracer.V4.extend;

import com.example.logtracer.V4.extend.logic.RepositoryLogic;
import com.example.logtracer.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ExtendsOrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {
        ExtendsAbstractTemplate<Void> template = new RepositoryLogic(trace);
        template.execute(itemId, "ExtendsOrderRepositoryV4.save()");
    }

}
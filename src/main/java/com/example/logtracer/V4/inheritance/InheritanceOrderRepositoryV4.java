package com.example.logtracer.V4.inheritance;

import com.example.logtracer.V4.inheritance.logic.RepositoryLogic;
import com.example.logtracer.logtrace.LogTrace;
import com.example.logtracer.template.InheritanceAbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InheritanceOrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {
        InheritanceAbstractTemplate<Void> template = new RepositoryLogic(trace);
        template.execute(itemId, "OrderRepositoryV4.save()");
    }

}
package com.github.d3a.engine.core.payload;

import com.github.d3a.engine.core.term.Entity;

import java.util.List;

public interface EntitiesRetrieveResult {
    public List<Entity> getConceptionEntities();
    public EntitiesRetrieveStatistics getOperationStatistics();
}

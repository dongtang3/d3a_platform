package com.github.d3a.engine.core.payload;

import java.util.List;

public interface EntitiesAttributesRetrieveResult {
    public List<EntityValue> getEntityValues();
    public EntitiesRetrieveStatistics getOperationStatistics();
}

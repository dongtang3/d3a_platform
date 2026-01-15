package com.github.d3a.engine.core.payload;

import java.util.List;

public interface EntitiesOperationResult {
    public List<String> getSuccessEntityUIDs();
    public EntitiesOperationStatistics getOperationStatistics();
}

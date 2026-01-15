package com.github.d3a.engine.core.payload;

import java.util.List;

public interface RelationEntitiesAttributesRetrieveResult {
    public List<RelationshipEntityValue> getRelationshipEntityValues();
    public EntitiesRetrieveStatistics getOperationStatistics();
}

package com.github.d3a.engine.core.payload;

import com.github.d3a.engine.core.term.RelationshipEntity;

import java.util.List;

public interface RelationshipEntitiesRetrieveResult {
    public List<RelationshipEntity> getRelationEntities();
    public EntitiesRetrieveStatistics getOperationStatistics();
}

package com.github.d3a.engine.core.feature.spi.neo4j.featureInf;

import com.github.d3a.engine.core.internal.neo4j.util.GraphOperationExecutorHelper;

public interface Neo4JKeyResourcesRetrievable {

    public String getEntityUID();
    public GraphOperationExecutorHelper getGraphOperationExecutorHelper();

}

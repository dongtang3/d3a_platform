package com.github.d3a.engine.core.term.spi.neo4j.termInf;

import com.github.d3a.engine.core.feature.TypeCacheable;
import com.github.d3a.engine.core.feature.spi.neo4j.featureInf.Neo4JMetaAttributeFeatureSupportable;
import com.github.d3a.engine.core.feature.spi.neo4j.featureInf.Neo4JMetaConfigItemFeatureSupportable;
import com.github.d3a.engine.core.term.Classification;

public interface Neo4JClassification extends Classification, Neo4JMetaConfigItemFeatureSupportable, Neo4JMetaAttributeFeatureSupportable, TypeCacheable {

}

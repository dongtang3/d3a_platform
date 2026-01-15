package com.github.d3a.engine.core.term.spi.neo4j.termInf;

import com.github.d3a.engine.core.feature.spi.neo4j.featureInf.Neo4JClassificationAttachable;
import com.github.d3a.engine.core.feature.spi.neo4j.featureInf.Neo4JMetaAttributeFeatureSupportable;
import com.github.d3a.engine.core.feature.spi.neo4j.featureInf.Neo4JMetaConfigItemFeatureSupportable;
import com.github.d3a.engine.core.term.AttributesView;

public interface Neo4JAttributesView extends AttributesView, Neo4JMetaConfigItemFeatureSupportable, Neo4JMetaAttributeFeatureSupportable, Neo4JClassificationAttachable {
}

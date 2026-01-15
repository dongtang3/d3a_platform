package com.github.d3a.engine.core.term.spi.neo4j.termInf;

import com.github.d3a.engine.core.feature.spi.neo4j.featureInf.Neo4JClassificationAttachable;
import com.github.d3a.engine.core.feature.spi.neo4j.featureInf.Neo4JMetaAttributeFeatureSupportable;
import com.github.d3a.engine.core.feature.spi.neo4j.featureInf.Neo4JMetaConfigItemFeatureSupportable;
import com.github.d3a.engine.core.term.Attribute;

public interface Neo4JAttribute extends Attribute, Neo4JMetaConfigItemFeatureSupportable, Neo4JMetaAttributeFeatureSupportable, Neo4JClassificationAttachable {

}

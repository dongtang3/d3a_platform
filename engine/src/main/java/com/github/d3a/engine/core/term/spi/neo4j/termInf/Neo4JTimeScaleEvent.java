package com.github.d3a.engine.core.term.spi.neo4j.termInf;

import com.github.d3a.engine.core.feature.AttributesMeasurable;
import com.github.d3a.engine.core.feature.ClassificationAttachable;
import com.github.d3a.engine.core.term.TimeScaleEvent;

public interface Neo4JTimeScaleEvent extends TimeScaleEvent, ClassificationAttachable, AttributesMeasurable {
}

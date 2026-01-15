package com.github.d3a.engine.core.internal.neo4j.dataTransformer;

import org.neo4j.driver.Result;

public interface DataTransformer<T> {
    public T transformResult(Result result);
}

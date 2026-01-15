package com.github.d3a.engine.core.util.cache;

public interface ResourceCacheQueryLogic <K,V> {
    public boolean filterLogic(K _kValue, V _VValue);
}

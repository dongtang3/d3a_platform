package com.github.d3a.engine.core.payload;

import com.github.d3a.engine.core.term.GeospatialScaleEvent;

import java.util.List;

public interface GeospatialScaleEventsRetrieveResult {
    public List<GeospatialScaleEvent> getGeospatialScaleEvents();
    public EntitiesRetrieveStatistics getOperationStatistics();
}

package com.github.d3a.engine.core.payload;

import com.github.d3a.engine.core.term.TimeScaleEvent;

import java.util.List;

public interface TimeScaleEventsRetrieveResult {
    public List<TimeScaleEvent> getTimeScaleEvents();
    public EntitiesRetrieveStatistics getOperationStatistics();
}

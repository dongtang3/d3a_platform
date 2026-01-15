package specialPurposeTestCase;

import com.github.d3a.engine.core.exception.EngineServiceRuntimeException;
import com.github.d3a.engine.core.term.Engine;
import com.github.d3a.engine.core.term.Geospatial;
import com.github.d3a.engine.core.term.TimeFlow;
import com.github.d3a.engine.core.util.factory.EngineFactory;

public class SystemInitTest {

    public static void main(String[] args) throws EngineServiceRuntimeException {
        Engine coreRealm = EngineFactory.getDefaultEngine();
        Geospatial geospatial = coreRealm.getOrCreateGeospatial();
        geospatial.createGeospatialScaleEntities();
        TimeFlow timeFlow = coreRealm.getOrCreateTimeFlow();
        timeFlow.createTimeSpanEntities(2021,false);
    }

}

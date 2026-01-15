package com.github.d3a.testcase.coreRealm.termTest;

import com.github.d3a.engine.core.exception.EngineFunctionNotSupportedException;
import com.github.d3a.engine.core.term.Engine;
import com.github.d3a.engine.core.term.spi.neo4j.termImpl.Neo4JEngineImpl;
import com.github.d3a.engine.core.util.StorageImplTech;
import com.github.d3a.engine.core.util.factory.EngineFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EngineFactoryTest {

    private static String testRealmName = "UNIT_TEST_Realm";

    @BeforeTest
    public void initData(){
        System.out.println("--------------------------------------------------");
        System.out.println("Init unit test data for RealmTermFactoryTest");
        System.out.println("--------------------------------------------------");
    }

    @Test
    public void testRealmTermFactoryFunction(){
        Engine coreRealm = EngineFactory.getDefaultEngine();
        Assert.assertTrue(coreRealm instanceof Neo4JEngineImpl);
        Assert.assertEquals(coreRealm.getStorageImplTech(), StorageImplTech.NEO4J);
        boolean exceptionShouldCaught = false;
        try {
            EngineFactory.getCoreRealm(testRealmName);
        }catch (EngineFunctionNotSupportedException e){
            exceptionShouldCaught = true;
        }
        Assert.assertTrue(exceptionShouldCaught);
    }
}

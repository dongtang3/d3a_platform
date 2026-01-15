package com.github.d3a.knowledgeManage.applicationCapacity.relationExtraction.commandProcessor;

import com.github.d3a.engine.core.term.Engine;
import com.github.d3a.knowledgeManage.consoleApplication.feature.BaseCommandProcessor;

import java.util.Map;
import java.util.concurrent.ExecutorService;

public class RelationExtractionCommandProcessorFactory {

    public static BaseCommandProcessor getCommandProcessor(String command, Engine coreRealm, ExecutorService executor, Map<Object,Object> commandContextDataMap){
        if(command.equalsIgnoreCase("re")){
            return new RelationExtractProcessor(coreRealm,executor,commandContextDataMap);
        }
        return null;
    }
}

package com.github.d3a.knowledgeManage.applicationService.ruleEngine;

import com.github.d3a.engine.core.term.Engine;
import org.kie.api.runtime.KieSession;

import java.util.Map;

public interface RuleFactsGenerator {
    public void generateRuleFacts(KieSession kSession, Engine coreRealm, Map<Object,Object> commandContextDataMap, String extractionId, String linkerId);
}

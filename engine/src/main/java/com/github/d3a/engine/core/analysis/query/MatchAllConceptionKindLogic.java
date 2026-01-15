package com.github.d3a.engine.core.analysis.query;

public class MatchAllConceptionKindLogic extends ConceptionKindMatchLogic{

    public MatchAllConceptionKindLogic(){
        super("*",ConceptionKindExistenceRule.MUST_HAVE);
    }
}

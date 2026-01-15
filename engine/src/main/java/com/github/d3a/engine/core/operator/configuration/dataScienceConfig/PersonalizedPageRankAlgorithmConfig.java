package com.github.d3a.engine.core.operator.configuration.dataScienceConfig;

import java.util.Set;

public class PersonalizedPageRankAlgorithmConfig extends PageRankAlgorithmConfig{

    private Set<String> personalizedPageRankEntityUIDs;

    public Set<String> getPersonalizedPageRankEntityUIDs() {
        return personalizedPageRankEntityUIDs;
    }

    public void setPersonalizedPageRankEntityUIDs(Set<String> personalizedPageRankEntityUIDs) {
        this.personalizedPageRankEntityUIDs = personalizedPageRankEntityUIDs;
    }
}

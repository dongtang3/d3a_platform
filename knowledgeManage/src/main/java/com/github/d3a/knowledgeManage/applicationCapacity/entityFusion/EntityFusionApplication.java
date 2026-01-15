package com.github.d3a.knowledgeManage.applicationCapacity.entityFusion;

import com.github.d3a.knowledgeManage.consoleApplication.feature.BaseApplication;

public class EntityFusionApplication implements BaseApplication {

    @Override
    public boolean isDaemonApplication() {
        return false;
    }

    @Override
    public void executeDaemonLogic() {

    }

    @Override
    public boolean initApplication() {
        return false;
    }

    @Override
    public boolean shutdownApplication() {
        return false;
    }

    @Override
    public void executeConsoleCommand(String consoleCommand) {

    }
}

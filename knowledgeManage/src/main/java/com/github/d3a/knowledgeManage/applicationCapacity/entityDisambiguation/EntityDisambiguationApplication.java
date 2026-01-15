package com.github.d3a.knowledgeManage.applicationCapacity.entityDisambiguation;

import com.github.d3a.knowledgeManage.consoleApplication.feature.BaseApplication;

public class EntityDisambiguationApplication implements BaseApplication {

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

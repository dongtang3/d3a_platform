package com.github.d3a.knowledgeManage.applicationCapacity.entityExtraction.commandProcessor;

import com.github.d3a.knowledgeManage.consoleApplication.feature.BaseCommandProcessor;
import com.github.d3a.knowledgeManage.consoleApplication.util.ApplicationLauncherUtil;

public class ClearCommandProcessor implements BaseCommandProcessor {
    @Override
    public void processCommand(String command, String[] commandOptions) {
        ApplicationLauncherUtil.printApplicationConsoleBanner();
    }
}

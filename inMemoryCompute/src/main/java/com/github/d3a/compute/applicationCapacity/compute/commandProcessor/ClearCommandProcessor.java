package com.github.d3a.compute.applicationCapacity.compute.commandProcessor;

import com.github.d3a.compute.consoleApplication.feature.BaseCommandProcessor;
import com.github.d3a.compute.consoleApplication.util.ApplicationLauncherUtil;

public class ClearCommandProcessor implements BaseCommandProcessor {
    @Override
    public void processCommand(String command, String[] commandOptions) {
        ApplicationLauncherUtil.printApplicationConsoleBanner();
    }
}

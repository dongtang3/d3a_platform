package com.github.d3a.compute.consoleApplication.feature;

public interface BaseApplication {

    public boolean initApplication();

    public boolean shutdownApplication();

    public void executeConsoleCommand(String consoleCommand);
}

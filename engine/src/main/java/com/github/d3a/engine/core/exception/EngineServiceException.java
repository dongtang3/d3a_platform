package com.github.d3a.engine.core.exception;

public class EngineServiceException extends Exception{

    public void setCauseMessage(String message){
        Throwable throwable=new Throwable("[ "+ message + " ]");
        this.initCause(throwable);
    }
}

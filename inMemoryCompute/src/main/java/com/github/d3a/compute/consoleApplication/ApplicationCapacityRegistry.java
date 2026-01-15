package com.github.d3a.compute.consoleApplication;

import com.github.d3a.compute.applicationCapacity.compute.DataComputeApplication;
import com.github.d3a.compute.consoleApplication.feature.BaseApplication;

public class ApplicationCapacityRegistry {
    public static BaseApplication createConsoleApplication(String applicationFunctionName){
        if(applicationFunctionName.equals("dataComputeApplication")){
            return new DataComputeApplication();
        }
        return null;
    }
}

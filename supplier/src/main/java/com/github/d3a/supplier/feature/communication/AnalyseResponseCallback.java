package com.github.d3a.supplier.feature.communication;

import com.github.d3a.supplier.feature.communication.messagePayload.AnalyseResponse;

public interface AnalyseResponseCallback {

    public void onResponseReceived(Object analyseResponseObject);

    public void onSuccessResponseReceived(AnalyseResponse analyseResponse);

    public void onFailureResponseReceived(Throwable throwable);
}

package com.github.d3a.knowledgeManage.consoleApplication;

import com.github.d3a.knowledgeManage.applicationCapacity.dataSlicesSynchronization.DataSlicesSynchronizationApplication;
import com.github.d3a.knowledgeManage.applicationCapacity.entityDisambiguation.EntityDisambiguationApplication;
import com.github.d3a.knowledgeManage.applicationCapacity.entityExtraction.EntityExtractionApplication;
import com.github.d3a.knowledgeManage.applicationCapacity.entityFusion.EntityFusionApplication;
import com.github.d3a.knowledgeManage.applicationCapacity.relationExtraction.RelationExtractionApplication;
import com.github.d3a.knowledgeManage.consoleApplication.feature.BaseApplication;

public class ApplicationCapacityRegistry {
    public static BaseApplication createConsoleApplication(String applicationFunctionName){
        if(applicationFunctionName.equals("relationExtraction")){
            return new RelationExtractionApplication();
        }
        if(applicationFunctionName.equals("entityExtraction")){
            return new EntityExtractionApplication();
        }
        if(applicationFunctionName.equals("entityFusion")){
            return new EntityFusionApplication();
        }
        if(applicationFunctionName.equals("entityDisambiguation")){
            return new EntityDisambiguationApplication();
        }
        if(applicationFunctionName.equals("dataSlicesSynchronization")){
            return new DataSlicesSynchronizationApplication();
        }
        return null;
    }
}

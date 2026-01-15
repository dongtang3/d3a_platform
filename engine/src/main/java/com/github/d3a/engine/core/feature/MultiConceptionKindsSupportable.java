package com.github.d3a.engine.core.feature;

import com.github.d3a.engine.core.exception.EngineServiceRuntimeException;

public interface MultiConceptionKindsSupportable {
    //心中有赤�?眼中有光�?
    /**
     * 将当前实体对象加入更多的概念类型�?
     *
     * @param newKindNames String[] 需要加入的概念类型列表
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean joinConceptionKinds(String[] newKindNames) throws EngineServiceRuntimeException;

    /**
     * 将当前实体对象退出指定概念类�?
     *
     * @param kindName String 需要退出的概念类型
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean retreatFromConceptionKind(String kindName) throws EngineServiceRuntimeException;
}


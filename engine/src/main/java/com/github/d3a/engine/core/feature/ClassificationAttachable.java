package com.github.d3a.engine.core.feature;

import com.github.d3a.engine.core.exception.EngineServiceRuntimeException;
import com.github.d3a.engine.core.payload.RelationshipAttachInfo;
import com.github.d3a.engine.core.term.Classification;
import com.github.d3a.engine.core.term.Direction;
import com.github.d3a.engine.core.term.RelationshipEntity;

import java.util.List;

public interface ClassificationAttachable {
    /**
     * 将当前对象关联到指定的分类上
     *
     * @param relationshipAttachInfo RelationAttachInfo 关联附着信息
     * @param classificationName String 分类名称
     *
     * @return 关联成功创建的关系实�?
     */
    RelationshipEntity attachClassification(RelationshipAttachInfo relationshipAttachInfo, String classificationName) throws EngineServiceRuntimeException;

    /**
     * 删除当前对象到指定分类的已有关联
     *
     * @param classificationName String 分类名称
     * @param relationKindName String 关系类型名称
     * @param direction Direction 关联方向
     *
     * @return 如操作成功，返回结果�?true
     */
    boolean detachClassification(String classificationName, String relationKindName, Direction direction) throws EngineServiceRuntimeException;

    /**
     * 获取当前对象已经关联的分�?
     *
     * @param relationKindName String 关系类型名称
     * @param direction Direction 关联方向
     *
     * @return 符合条件的分类列�?
     */
    List<Classification> getAttachedClassifications(String relationKindName, Direction direction);
}


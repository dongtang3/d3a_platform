package com.github.d3a.engine.core.term;

import com.github.d3a.engine.core.feature.AttributesMeasurable;
import com.github.d3a.engine.core.structure.PathEntity;

import java.util.List;

public interface RelationshipEntity extends AttributesMeasurable, PathEntity {
    /**
     * 获取当前关系实体对象唯一ID
     *
     * @return 关系实体对象唯一ID
     */
    public String getRelationshipEntityUID();

    /**
     * 获取当前关系实体所属关系类型名�?
     *
     * @return 关系类型名称
     */
    public String getRelationTypeName();

    /**
     * 获取当前关系实体的来源概念实体唯一ID
     *
     * @return 概念实体对象唯一ID
     */
    public String getFromEntityUID();

    /**
     * 获取当前关系实体的目标概念实体唯一ID
     *
     * @return 概念实体对象唯一ID
     */
    public String getToEntityUID();

    /**
     * 获取当前关系实体的来源概念实体所属概念类�?
     *
     * @return 概念实体所属类型列�?
     */
    public List<String> getFromEntityKinds();

    /**
     * 获取当前关系实体的目标概念实体所属概念类�?
     *
     * @return 概念实体所属类型列�?
     */
    public List<String> getToEntityKinds();
}

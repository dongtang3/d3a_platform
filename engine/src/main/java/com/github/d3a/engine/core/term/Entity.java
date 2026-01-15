package com.github.d3a.engine.core.term;

import com.github.d3a.engine.core.feature.*;
import com.github.d3a.engine.core.structure.PathEntity;

import java.util.List;

public interface Entity extends AttributesMeasurable, EntityRelationable, ClassificationAttachable, MultiConceptionKindsSupportable, TimeScaleFeatureSupportable, GeospatialScaleFeatureSupportable, PathTravelable, PathEntity, GeospatialScaleCalculable {
    /**
     * 获取当前概念实体对象唯一ID
     *
     * @return 概念实体对象唯一ID
     */
    public String getEntityUID();

    /**
     * 获取当前操作上下文中概念实体对象所属的概念类型名称
     *
     * @return 概念类型名称
     */
    public String getConceptionKindName();

    /**
     * 获取当前概念实体对象所属的所有概念类型名�?
     *
     * @return 概念类型名称列表
     */
    public List<String> getAllConceptionKindNames();
}

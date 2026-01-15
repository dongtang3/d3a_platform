package com.github.d3a.engine.core.term;

import com.github.d3a.engine.core.exception.EngineServiceRuntimeException;
import com.github.d3a.engine.core.feature.ClassificationAttachable;
import com.github.d3a.engine.core.feature.MetaAttributeFeatureSupportable;
import com.github.d3a.engine.core.feature.MetaConfigItemFeatureSupportable;
import com.github.d3a.engine.core.payload.EntitiesOperationResult;
import com.github.d3a.engine.core.payload.RelationshipAttachLinkLogic;

import java.util.List;
import java.util.Map;

public interface RelationshipAttach extends MetaConfigItemFeatureSupportable, MetaAttributeFeatureSupportable, ClassificationAttachable {
    /**
     * 构建关联关系时当前实体在关系中所属的角色
     * SOURCE : 当前实体是关联关系的出发�?(FROM)�?
     * TARGET : 当前实体是关联关系的目标�?(TO)�?
     */
    public enum EntityRelateRole { SOURCE, TARGET }

    /**
     * 构建关联关系时实体匹配逻辑类型
     * DEFAULT : 默认匹配条件，每个关系附着规则类型必须有且只有一项�?
     * AND : 逻辑 �?匹配条件�?
     * OR : 逻辑 �?匹配条件�?
     */
    public enum LinkLogicType { DEFAULT, AND, OR }

    /**
     * 构建关联关系时实体匹配计算规�?
     * Equal : 属性值相等�?
     * GreaterThanEqual : 属性值大于等于�?
     * GreaterThan : 属性值大于�?
     * LessThanEqual : 属性值小于等于�?
     * LessThan : 属性值小于�?
     * NotEqual : 属性值不等�?
     * RegularMatch : 属性值正则表达式匹配�?
     * BeginWithSimilar : 属性值开始包含�?
     * EndWithSimilar : 属性值结束包含�?
     * ContainSimilar : 属性值包含�?
     */
    public enum LinkLogicCondition { Equal,GreaterThanEqual,GreaterThan,LessThanEqual,LessThan,NotEqual,RegularMatch,BeginWithSimilar, EndWithSimilar, ContainSimilar }

    /**
     * 获取当前关系附着规则类型对象唯一ID
     *
     * @return 关系附着规则类型对象唯一ID
     */
    public String getRelationAttachKindUID();

    /**
     * 获取当前关系附着规则类型的来源概念类型名�?
     *
     * @return 来源概念类型名称
     */
    public String getSourceConceptionKindName();

    /**
     * 获取当前关系附着规则类型的目标概念类型名�?
     *
     * @return 目标概念类型名称
     */
    public String getTargetConceptionKindName();

    /**
     * 获取当前关系附着规则类型的关系类型名�?
     *
     * @return 关系类型名称
     */
    public String getRelationKindName();

    /**
     * 获取当前关系附着规则类型名称
     *
     * @return 关系附着规则类型名称
     */
    public String getRelationAttachKindName();

    /**
     * 获取当前关系附着规则类型描述
     *
     * @return 关系附着规则类型描述
     */
    public String getRelationAttachKindDesc();

    /**
     * 获取当前关系附着规则类型的描�?
     *
     * @param newDesc String 新的关系附着规则类型描述
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean updateRelationAttachKindDesc(String newDesc);

    /**
     * 获取当前关系附着规则类型的所有关系附着逻辑规则
     *
     * @return 关系附着逻辑规则列表
     */
    public List<RelationshipAttachLinkLogic> getRelationAttachLinkLogic();

    /**
     * 为当前关系附着规则类型创建新的关系附着逻辑规则
     *
     * @param relationshipAttachLinkLogic RelationAttachLinkLogic 新的关系附着逻辑规则对象
     *
     * @return 新建的关系附着逻辑规则逻辑
     */
    public RelationshipAttachLinkLogic createRelationAttachLinkLogic(RelationshipAttachLinkLogic relationshipAttachLinkLogic) throws EngineServiceRuntimeException;

    /**
     * 删除当前关系附着规则类型中已有的关系附着逻辑规则
     *
     * @param relationAttachLinkLogicUID String 要删除的关系附着逻辑规则对象唯一ID
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean removeRelationAttachLinkLogic(String relationAttachLinkLogicUID) throws EngineServiceRuntimeException;

    /**
     * 使用当前关系附着规则类型的逻辑创建新的关系实体
     *
     * @param conceptionEntityUID String 概念实体对象唯一ID
     * @param entityRelateRole EntityRelateRole 概念实体在关系中的角�?
     * @param relationData Map<String,Object> 关系实体上的自定义属�?
     *
     * @return 新创建的概念实体对象数量
     */
    public long newRelationEntities(String conceptionEntityUID, EntityRelateRole entityRelateRole, Map<String,Object> relationData);

    /**
     * 使用当前关系附着规则类型的逻辑创建新的关系实体
     *
     * @param conceptionEntityUIDs List<String> 概念实体对象唯一ID列表
     * @param entityRelateRole EntityRelateRole 概念实体在关系中的角�?
     * @param relationData Map<String,Object> 关系实体上的自定义属�?
     *
     * @return 新创建的概念实体对象数量
     */
    public long newRelationEntities(List<String> conceptionEntityUIDs, EntityRelateRole entityRelateRole, Map<String,Object> relationData);

    /**
     * 使用当前关系附着规则类型的定义在领域内的全部数据上创建符合条件的关系实体
     *
     * @param relationData Map<String,Object> 关系实体上的自定义属�?
     * @return 实体对象操作返回结果
     */
    public EntitiesOperationResult newUniversalRelationEntities(Map<String,Object> relationData);

    /**
     * 是否允许在同样的两个实体之间创建相同关系类型的关系实�?
     *
     * @return 如允许则返回 true
     */
    public boolean isRepeatableRelationKindAllow();

    /**
     * 设定是否允许在同样的两个实体之间创建相同关系类型的关系实�?
     *
     * @param allowRepeatableRelationKind boolean 是否允许创建相同关系类型的实�?
     *
     * @return 返回最新的是否允许状�?
     */
    public boolean setAllowRepeatableRelationKind(boolean allowRepeatableRelationKind);
}

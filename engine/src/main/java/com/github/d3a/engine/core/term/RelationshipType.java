package com.github.d3a.engine.core.term;

import com.github.d3a.engine.core.analysis.query.AttributesParameters;
import com.github.d3a.engine.core.analysis.query.QueryParameters;
import com.github.d3a.engine.core.exception.EngineFunctionNotSupportedException;
import com.github.d3a.engine.core.exception.EngineServiceEntityExploreException;
import com.github.d3a.engine.core.exception.EngineServiceRuntimeException;
import com.github.d3a.engine.core.feature.ClassificationAttachable;
import com.github.d3a.engine.core.feature.MetaAttributeFeatureSupportable;
import com.github.d3a.engine.core.feature.MetaConfigItemFeatureSupportable;
import com.github.d3a.engine.core.feature.StatisticalAndEvaluable;
import com.github.d3a.engine.core.payload.EntitiesOperationResult;
import com.github.d3a.engine.core.payload.RelationDegreeDistributionInfo;
import com.github.d3a.engine.core.payload.RelationEntitiesAttributesRetrieveResult;
import com.github.d3a.engine.core.payload.RelationshipEntitiesRetrieveResult;
import com.github.d3a.engine.core.structure.InheritanceTree;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RelationshipType extends MetaConfigItemFeatureSupportable, MetaAttributeFeatureSupportable, ClassificationAttachable, StatisticalAndEvaluable {
    /**
     * 获取当前关系类型对象名称
     *
     * @return 关系类型对象名称
     */
    public String getRelationKindName();

    /**
     * 获取当前关系类型对象描述
     *
     * @return 关系类型对象描述
     */
    public String getRelationKindDesc();

    /**
     * 更新当前关系类型对象描述
     *
     * @param kindDesc String 新的关系类型描述
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean updateRelationKindDesc(String kindDesc);

    /**
     * 获取当前关系类型的父关系类型对象，该方法�?NEO4J 实现类型下无�?
     *
     * @return 关系类型对象
     */
    public RelationshipType getParentRelationKind() throws EngineFunctionNotSupportedException;

    /**
     * 获取当前关系类型的所有子关系类型对象，该方法�?NEO4J 实现类型下无�?
     *
     * @return 关系类型对象列表
     */
    public List<RelationshipType> getChildRelationKinds() throws EngineFunctionNotSupportedException;

    /**
     * 获取当前关系类型的所有后代关系类型对象，该方法在 NEO4J 实现类型下无�?
     *
     * @return 关系类型对象继承�?
     */
    public InheritanceTree<RelationshipType> getOffspringRelationKinds() throws EngineFunctionNotSupportedException;

    /**
     * 计算当前关系类型的所有关系实体数�?
     *
     * @return 关系实体数量
     */
    public Long countRelationEntities() throws EngineServiceRuntimeException;

    /**
     * 计算当前关系类型（包含所有后代关系类型）的所有关系实体数量，该方法在 NEO4J 实现类型下无�?
     *
     * @return 关系实体数量
     */
    public Long countRelationEntitiesWithOffspring() throws EngineFunctionNotSupportedException;

    /**
     * 计算符合过滤条件的当前关系类型的关系实体对象数量
     *
     * @param attributesParameters AttributesParameters 查询过滤条件
     * @param isDistinctMode boolean 是否不允许重复数�?
     *
     * @return 关系实体数量
     */
    public Long countRelationEntities(AttributesParameters attributesParameters, boolean isDistinctMode) throws EngineServiceEntityExploreException, EngineServiceRuntimeException;

    /**
     * 查询符合过滤条件的当前关系类型的关系实体对象
     *
     * @param queryParameters QueryParameters 查询过滤条件
     *
     * @return 关系实体查询结果�?
     */
    public RelationshipEntitiesRetrieveResult getRelationEntities(QueryParameters queryParameters)  throws EngineServiceEntityExploreException;

    /**
     * 删除当前关系类型的所有关系实�?
     *
     * @return 实体对象操作返回结果
     */
    public EntitiesOperationResult purgeAllRelationEntities() throws EngineServiceRuntimeException;

    /**
     * 查询符合过滤条件的当前概念类型的关系实体对象,并根据输入的属性类型返回相应的属性�?
     *
     * @param attributeNames List<String> 属性类型列�?
     * @param exploreParameters QueryParameters 查询过滤条件
     *
     * @return 关系实体属性查询结果集
     */
    public RelationEntitiesAttributesRetrieveResult getEntityAttributesByAttributeNames(List<String> attributeNames, QueryParameters exploreParameters) throws EngineServiceEntityExploreException;

    /**
     * 根据唯一ID获取当前关系类型的关系实体对�?
     *
     * @param relationEntityUID String 需要获取的关系实体唯一ID
     *
     * @return 关系实体对象
     */
    public RelationshipEntity getEntityByUID(String relationEntityUID);

    /**
     * 计算当前关系类型的所有关系实体的度分�?
     *
     * @param direction Direction 关系关联方向
     *
     * @return 关系实体度分布信息对�?
     */
    public RelationDegreeDistributionInfo computeRelationDegreeDistribution(Direction direction);

    /**
     * 随机获取若干当前关系类型下的关系实体
     *
     * @param entitiesCount int 需要获取的关系实体数量
     *
     * @return 关系实体集合
     */
    public Set<RelationshipEntity> getRandomEntities(int entitiesCount) throws EngineServiceEntityExploreException;

    /**
     * 随机获取若干符合过滤条件的当前关系类型的关系实体
     *
     * @param attributesParameters AttributesParameters 查询过滤条件
     * @param isDistinctMode boolean 是否不允许重复数�?
     * @param entitiesCount int 需要获取的关系实体数量
     *
     * @return 关系实体集合
     */
    public Set<RelationshipEntity> getRandomEntities(AttributesParameters attributesParameters, boolean isDistinctMode, int entitiesCount) throws EngineServiceEntityExploreException, EngineServiceRuntimeException;

    /**
     * 为当前关系类型的所有关系实体添加指定的属性，如属性已经存在，则用新的值覆盖原有属�?
     *
     * @param attributes Map<String, Object> 需要添加的所有属�?
     *
     * @return 操作成功的数据总量
     */
    public long setKindScopeAttributes(Map<String, Object> attributes);

    /**
     * 删除当前关系类型的关系实体，这些关系实体指向的源概念实体与目标概念实体相�?(具有相同的唯一ID)
     *
     * @return 操作删除的关系实体数�?
     */
    public long purgeRelationsOfSelfAttachedConceptionEntities();

    /**
     * 删除一个当前关系类型的关系实体对象
     *
     * @param relationEntityUID String 需要删除的关系实体的唯一ID
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean deleteEntity(String relationEntityUID) throws EngineServiceRuntimeException;

    /**
     * 更新多个当前关系类型的关系实体对�?
     *
     * @param relationEntityUIDs List<String> 需要删除的关系实体的唯一ID列表
     *
     * @return 删除实体对象操作返回结果
     */
    public EntitiesOperationResult deleteEntities(List<String> relationEntityUIDs) throws EngineServiceRuntimeException;
}

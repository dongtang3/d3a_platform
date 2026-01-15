package com.github.d3a.engine.core.feature;

import com.github.d3a.engine.core.analysis.query.AttributesParameters;
import com.github.d3a.engine.core.analysis.query.QueryParameters;
import com.github.d3a.engine.core.analysis.query.RelationKindMatchLogic;
import com.github.d3a.engine.core.analysis.query.ResultEntitiesParameters;
import com.github.d3a.engine.core.exception.EngineServiceEntityExploreException;
import com.github.d3a.engine.core.exception.EngineServiceRuntimeException;
import com.github.d3a.engine.core.payload.EntitiesAttributesRetrieveResult;
import com.github.d3a.engine.core.term.Direction;
import com.github.d3a.engine.core.term.Entity;
import com.github.d3a.engine.core.term.RelationshipEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EntityRelationable {
    /**
     关联传播停止逻辑,
     AT 表示只返�?jumpNumber 指定跳数的实体，
     TO 表示返回�?0 �?jumpNumber 沿途所有符合条件的实体
    **/
    public enum JumpStopLogic {
        AT,TO }

    /**
     * 计算当前实体的所有数据关联数�?
     *
     * @return 关联数量
     */
    public Long countAllRelations();

    /**
     * 计算当前实体的特定关系类型下的数据关联数�?
     *
     * @param relationType String 关系类型名称
     * @param direction Direction 关系关联方向
     *
     * @return 符合条件的关联数�?
     */
    public Long countAllSpecifiedRelations(String relationType, Direction direction) throws EngineServiceRuntimeException;

    /**
     * 计算当前实体的符合特定查询条件的数据关联数量
     *
     * @param exploreParameters QueryParameters 关系属性查询条�?
     * @param direction Direction 关系关联方向
     *
     * @return 符合条件的关联数�?
     */
    public Long countSpecifiedRelations(QueryParameters exploreParameters, Direction direction) throws EngineServiceRuntimeException;

    /**
     * 获取与当前实体相关的所有数据关系实�?
     *
     * @return 关系实体列表
     */
    public List<RelationshipEntity> getAllRelations();

    /**
     * 获取当前实体的特定关系类型下的关系实�?
     *
     * @param relationKind String 关系类型名称
     * @param direction Direction 关系关联方向
     *
     * @return 关系实体列表
     */
    public List<RelationshipEntity> getAllSpecifiedRelations(String relationKind, Direction direction) throws EngineServiceRuntimeException;

    /**
     * 获取当前实体的符合特定查询条件的关系实体
     *
     * @param exploreParameters QueryParameters 关系属性查询条�?
     * @param direction Direction 关系关联方向
     *
     * @return 关系实体列表
     */
    public List<RelationshipEntity> getSpecifiedRelations(QueryParameters exploreParameters, Direction direction) throws EngineServiceRuntimeException;

    /**
     * 为当前实体附着源数据关�?
     *
     * @param targetRelationableUID String 目标实体唯一ID
     * @param relationKind String 关系类型名称
     * @param initRelationProperties Map<String,Object> 新建的关系实体上的初始属性信�?
     * @param repeatable boolean 是否允许重复建立已有关系类型的数据关�?
     *
     * @return 新建的关系实�?
     */
    public RelationshipEntity attachFromRelation(String targetRelationableUID, String relationKind, Map<String,Object> initRelationProperties, boolean repeatable) throws EngineServiceRuntimeException;

    /**
     * 为当前实体附着目标数据关联
     *
     * @param targetRelationableUID String 目标实体唯一ID
     * @param relationKind String 关系类型名称
     * @param initRelationProperties Map<String,Object> 新建的关系实体上的初始属性信�?
     * @param repeatable boolean 是否允许重复建立已有关系类型的数据关�?
     *
     * @return 新建的关系实�?
     */
    public RelationshipEntity attachToRelation(String targetRelationableUID, String relationKind, Map<String,Object> initRelationProperties, boolean repeatable) throws EngineServiceRuntimeException;

    /**
     * 为当前实体附着多个源数据关�?
     *
     * @param targetRelationableUIDs List<String> 目标实体唯一ID列表
     * @param relationKind String 关系类型名称
     * @param initRelationProperties Map<String,Object> 新建的关系实体上的初始属性信�?
     * @param repeatable boolean 是否允许重复建立已有关系类型的数据关�?
     *
     * @return 新建的关系实体列�?
     */
    public List<RelationshipEntity> attachFromRelation(List<String> targetRelationableUIDs, String relationKind, Map<String,Object> initRelationProperties, boolean repeatable) throws EngineServiceRuntimeException;

    /**
     * 为当前实体附着多个目标数据关联
     *
     * @param targetRelationableUIDs List<String> 目标实体唯一ID列表
     * @param relationKind String 关系类型名称
     * @param initRelationProperties Map<String,Object> 新建的关系实体上的初始属性信�?
     * @param repeatable boolean 是否允许重复建立已有关系类型的数据关�?
     *
     * @return 新建的关系实体列�?
     */
    public List<RelationshipEntity> attachToRelation(List<String> targetRelationableUIDs, String relationKind, Map<String,Object> initRelationProperties, boolean repeatable) throws EngineServiceRuntimeException;

    /**
     * 根据关系实体唯一ID删除当前实体的特定数据关�?
     *
     * @param relationEntityUID String 需要删除的关系实体唯一ID
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean detachRelation(String relationEntityUID) throws EngineServiceRuntimeException;

    /**
     * 删除当前实体的所有数据关�?
     *
     * @return 删除成功的关系实体唯一ID列表
     */
    public List<String> detachAllRelations();

    /**
     * 删除当前实体的特定关系类型下的关系实�?
     *
     * @param relationType String 关系类型名称
     * @param direction Direction 关系关联方向
     *
     * @return 删除成功的关系实体唯一ID列表
     */
    public List<String> detachAllSpecifiedRelations(String relationType, Direction direction) throws EngineServiceRuntimeException;

    /**
     * 删除当前实体的符合特定查询条件的关系实体
     *
     * @param exploreParameters QueryParameters 关系属性查询条�?
     * @param direction Direction 关系关联方向
     *
     * @return 删除成功的关系实体唯一ID列表
     */
    public List<String> detachSpecifiedRelations(QueryParameters exploreParameters, Direction direction) throws EngineServiceRuntimeException;

    /**
     * 计算与当前实体关联的概念实体数量
     *
     * @param targetConceptionKind String 目标概念类型名称
     * @param relationKind String 目标关系类型名称
     * @param direction Direction 关系关联方向
     * @param maxJump int 关联传播的最大跳�?
     *
     * @return 符合条件的概念实体数�?
     */
    public Long countRelatedConceptionEntities(String targetConceptionKind, String relationKind, Direction direction, int maxJump);

    /**
     * 获取与当前实体关联的概念实体
     *
     * @param targetConceptionKind String 目标概念类型名称
     * @param relationKind String 目标关系类型名称
     * @param direction Direction 关系关联方向
     * @param maxJump int 关联传播的最大跳�?
     *
     * @return 符合条件的概念实体对象列�?
     */
    public List<Entity> getRelatedConceptionEntities(String targetConceptionKind, String relationKind, Direction direction, int maxJump);

    /**
     * 获取与当前实体关联的概念实体,并根据输入的属性类型返回相应的属性�?
     *
     * @param targetConceptionKind String 目标概念类型名称
     * @param attributeNames List<String> 返回属性类型列�?
     * @param relationKind String 目标关系类型名称
     * @param direction Direction 关系关联方向
     * @param maxJump int 关联传播的最大跳�?
     *
     * @return 概念实体属性查询结果集
     */
    public EntitiesAttributesRetrieveResult getAttributesOfRelatedConceptionEntities(String targetConceptionKind, List<String> attributeNames, String relationKind, Direction direction, int maxJump);

    /**
     * 计算与当前实体关联的概念实体数量
     *
     * @param targetConceptionKind String 目标概念类型名称
     * @param relationKind String 目标关系类型名称
     * @param direction Direction 关系关联方向
     * @param maxJump int 关联传播的最大跳�?
     * @param relationAttributesParameters AttributesParameters 需要获取的数据的关系实体属性查询条�?
     * @param conceptionAttributesParameters AttributesParameters 需要获取的数据的概念实体属性查询条�?
     * @param isDistinctMode boolean 是否不允许重复数�?
     *
     * @return 符合条件的概念实体数�?
     */
    public Long countRelatedConceptionEntities(String targetConceptionKind, String relationKind, Direction direction, int maxJump,
                                               AttributesParameters relationAttributesParameters, AttributesParameters conceptionAttributesParameters, boolean isDistinctMode) throws EngineServiceEntityExploreException;

    /**
     * 获取与当前实体关联的概念实体
     *
     * @param targetConceptionKind String 目标概念类型名称
     * @param relationKind String 目标关系类型名称
     * @param direction Direction 关系关联方向
     * @param maxJump int 关联传播的最大跳�?
     * @param relationAttributesParameters AttributesParameters 需要获取的数据的关系实体属性查询条�?
     * @param conceptionAttributesParameters AttributesParameters 需要获取的数据的概念实体属性查询条�?
     * @param resultEntitiesParameters ResultEntitiesParameters 返回概念实体数据的控制参�?
     *
     * @return 符合条件的概念实体对象列�?
     */
    public List<Entity> getRelatedConceptionEntities(String targetConceptionKind, String relationKind, Direction direction, int maxJump,
                                                     AttributesParameters relationAttributesParameters, AttributesParameters conceptionAttributesParameters, ResultEntitiesParameters resultEntitiesParameters) throws EngineServiceEntityExploreException;

    /**
     * 获取与当前实体关联的概念实体,并根据输入的属性类型返回相应的属性�?
     *
     * @param targetConceptionKind String 目标概念类型名称
     * @param attributeNames List<String> 返回属性类型列�?
     * @param relationKind String 目标关系类型名称
     * @param direction Direction 关系关联方向
     * @param maxJump int 关联传播的最大跳�?
     * @param relationAttributesParameters AttributesParameters 需要获取的数据的关系实体属性查询条�?
     * @param conceptionAttributesParameters AttributesParameters 需要获取的数据的概念实体属性查询条�?
     * @param resultEntitiesParameters ResultEntitiesParameters 返回概念实体数据的控制参�?
     *
     * @return 概念实体属性查询结果集
     */
    public EntitiesAttributesRetrieveResult getAttributesOfRelatedConceptionEntities(String targetConceptionKind, List<String> attributeNames, String relationKind, Direction direction, int maxJump,
                                                                                     AttributesParameters relationAttributesParameters, AttributesParameters conceptionAttributesParameters, ResultEntitiesParameters resultEntitiesParameters) throws EngineServiceEntityExploreException;

    /**
     * 获取与当前实体关联的概念实体
     *
     * @param relationKindMatchLogics List<RelationKindMatchLogic> 目标关系类型名称与关系方向组合，如存在该参数至少需要输入一项数�?
     * @param defaultDirectionForNoneRelationKindMatch Direction 未输入目标关系类型名称与关系方向组合时使用的全局关系方向，必须为 Direction.FROM �?Direction.TO
     * @param jumpStopLogic JumpStopLogic 关联传播停止逻辑 JumpStopLogic.AT 只返�?jumpNumber 指定跳数的概念实体，JumpStopLogic.TO 返回�?0 �?jumpNumber 沿途所有符合条件的概念实体
     * @param jumpNumber int 关联传播的跳�?
     * @param conceptionAttributesParameters AttributesParameters 需要获取的数据的概念实体属性查询条�?
     * @param resultEntitiesParameters ResultEntitiesParameters 返回概念实体数据的控制参�?
     *
     * @return 符合条件的概念实体对象列�?
     */
    public List<Entity> getRelatedConceptionEntities(List<RelationKindMatchLogic> relationKindMatchLogics, Direction defaultDirectionForNoneRelationKindMatch, JumpStopLogic jumpStopLogic, int jumpNumber,
                                                     AttributesParameters conceptionAttributesParameters, ResultEntitiesParameters resultEntitiesParameters) throws EngineServiceEntityExploreException;

    /**
     * 计算与当前实体关联的概念实体数量
     *
     * @param relationKindMatchLogics List<RelationKindMatchLogic> 目标关系类型名称与关系方向组合，如存在该参数至少需要输入一项数�?
     * @param defaultDirectionForNoneRelationKindMatch Direction 未输入目标关系类型名称与关系方向组合时使用的全局关系方向，必须为 Direction.FROM �?Direction.TO
     * @param jumpStopLogic JumpStopLogic 关联传播停止逻辑 JumpStopLogic.AT 只返�?jumpNumber 指定跳数的概念实体，JumpStopLogic.TO 返回�?0 �?jumpNumber 沿途所有符合条件的概念实体
     * @param jumpNumber int 关联传播的跳�?
     * @param conceptionAttributesParameters AttributesParameters 需要获取的数据的概念实体属性查询条�?
     *
     * @return 符合条件的概念实体数�?
     */
    public Long countRelatedConceptionEntities(List<RelationKindMatchLogic> relationKindMatchLogics, Direction defaultDirectionForNoneRelationKindMatch, JumpStopLogic jumpStopLogic, int jumpNumber,
                                               AttributesParameters conceptionAttributesParameters) throws EngineServiceEntityExploreException;

    /**
     * 判断当前实体对象是否稠密节点
     *
     * @return 如是稠密节点返回 true，否则返�?false
     */
    public boolean isDense();

    /**
     * 判断当前实体对象是否与目标实体关�?
     *
     * @param targetRelationableUID String 目标实体唯一ID
     * @param relationKindMatchLogics List<RelationKindMatchLogic> 目标关系类型名称与关系方向组�?
     *
     * @return 如关联返�?true，否则返�?false
     */
    public boolean isAttachedWith(String targetRelationableUID, List<RelationKindMatchLogic> relationKindMatchLogics) throws EngineServiceRuntimeException;

    /**
     * 获取当前实体对象的所有关联的关系类型
     *
     * @return 关系类型名称列表
     */
    public List<String> listAttachedRelationKinds();

    /**
     * 检查当前实体对象是否存在由关系类型名称与关系方向组合描述的数据关联
     * @param relationKindMatchLogics List<RelationKindMatchLogic> 目标关系类型名称与关系方向组合列�?
     *
     * @return 目标关系类型名称与关系方向组合和检查结果的Map，如存在关系类型名称与关系方向组合描述的关系实体数据则返回true，反之返回false
     */
    public Map<RelationKindMatchLogic,Boolean> checkRelationKindAttachExistence(List<RelationKindMatchLogic> relationKindMatchLogics);

    /**
     * 获取当前实体对象的所有关联的关系类型以及对应的关系实体数�?
     *
     * @return 关系类型名称 + 关系实体数量 Map
     */
    public Map<String,Long> countAttachedRelationKinds();

    /**
     * 获取当前实体对象的所有关联的概念类型
     *
     * @return 概念类型名称列表
     */
    public List<String> listAttachedConceptionKinds();

    /**
     * 获取当前实体对象的所有关联的概念类型以及对应的概念实体数�?
     *
     * @return 概念类型名称集合 + 关系实体数量 Map
     */
    public Map<Set<String>,Long> countAttachedConceptionKinds();
}

package com.github.d3a.engine.core.operator;

import com.github.d3a.engine.core.exception.EngineServiceRuntimeException;
import com.github.d3a.coreRealm.realmServiceCore.payload.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SystemMaintenanceOperator {
    //听风雪喧�?看流星在飞翔 我的心向我呼�?去动荡的远方

    /**
     * 搜索索引创建算法
     */
    public enum SearchIndexType {BTREE, FULLTEXT, LOOKUP}

    /**
     * 查询并返回当前领域模型所属数据服务系统的事实数据状态快照信�?
     *
     * @return 数据状态实时快照信�?
     */
    public DataStatusSnapshotInfo getDataStatusSnapshot();

    /**
     * 查询并返回当前领域模型所属数据服务系统的系统运行状态快照信�?
     *
     * @return 系统运行状态快照信�?
     */
    public SystemStatusSnapshotInfo getSystemStatusSnapshot();

    /**
     * 查询指定概念类型的实体数据中的属性的系统信息
     *
     * @param conceptionKindName String 概念类型名称
     *
     * @return 属性系统信息列�?
     */
    public List<AttributeSystemInfo> getConceptionKindAttributesSystemInfo(String conceptionKindName);

    /**
     * 查询所有概念类型的实体数据中的属性的系统信息
     *
     * @return 所有的概念类型名称与其中包含的属性系统信息列表的映射字典
     */
    public Map<String,List<AttributeSystemInfo>> getAllConceptionKindsAttributesSystemInfo();

    /**
     * 查询指定关系类型的实体数据中的属性的系统信息
     *
     * @param relationKindName String 关系类型名称
     *
     * @return 属性系统信息列�?
     */
    public List<AttributeSystemInfo> getRelationKindAttributesSystemInfo(String relationKindName);

    /**
     * 查询所有关系类型的实体数据中的属性的系统信息
     *
     * @return 所有的关系类型名称与其中包含的属性系统信息列表的映射字典
     */
    public Map<String,List<AttributeSystemInfo>> getAllRelationKindsAttributesSystemInfo();

    /**
     * 在当前领域模型中创建针对概念类型的搜索索�?
     *
     *  @param indexName String 搜索索引名称
     *  @param indexType SearchIndexType 搜索索引算法类型
     *  @param conceptionKindName String 搜索概念类型名称
     *  @param indexAttributeNames Set<String> 索引包含的数据属性集�?
     *
     * @return 如创建索引成功返�?true
     */
    public boolean createConceptionKindSearchIndex(String indexName, SearchIndexType indexType, String conceptionKindName, Set<String> indexAttributeNames) throws EngineServiceRuntimeException;

    /**
     * 在当前领域模型中创建针对关系类型的搜索索�?
     *
     *  @param indexName String 搜索索引名称
     *  @param indexType SearchIndexType 搜索索引算法类型
     *  @param relationKindName String 搜索关系类型名称
     *  @param indexAttributeNames Set<String> 索引包含的数据属性集�?
     *
     * @return 如创建索引成功返�?true
     */
    public boolean createRelationKindSearchIndex(String indexName, SearchIndexType indexType, String relationKindName, Set<String> indexAttributeNames) throws EngineServiceRuntimeException;

    /**
     * 显示当前领域模型中的所有概念类型搜索索�?
     *
     * @return 概念类型搜索索引信息集合
     */
    public Set<SearchIndexInfo> listConceptionKindSearchIndex();

    /**
     * 显示当前领域模型中的所有关系类型搜索索�?
     *
     * @return 关系类型搜索索引信息集合
     */
    public Set<SearchIndexInfo> listRelationKindSearchIndex();

    /**
     * 在当前领域模型中删除指定的概念类型搜索索�?
     *
     *  @param indexName String 待删除的搜索索引名称
     *
     * @return 如删除索引成功返�?true
     */
    public boolean removeConceptionKindSearchIndex(String indexName) throws EngineServiceRuntimeException;

    /**
     * 在当前领域模型中删除指定的关系类型搜索索�?
     *
     *  @param indexName String 待删除的搜索索引名称
     *
     * @return 如删除索引成功返�?true
     */
    public boolean removeRelationKindSearchIndex(String indexName) throws EngineServiceRuntimeException;

    /**
     * 统计系统中所有概念类型实体与其他概念类型实体之间的实时关联关系信�?
     *
     * @return 所有概念类型之间的关联关系信息集合
     */
    public Set<ConceptionKindCorrelationInfo> getSystemConceptionKindsRelationDistributionStatistics();

    /**
     * 统计系统中包含内部概念类型实体在内的所有概念类型实体与其他概念类型实体之间的实时关联关系信�?
     *
     * @return 所有概念类型之间的关联关系信息集合
     */
    public Set<ConceptionKindCorrelationInfo> getAllDataRelationDistributionStatistics();
}

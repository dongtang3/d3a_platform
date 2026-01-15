package com.github.d3a.engine.core.feature;

import com.github.d3a.engine.core.analysis.query.AttributesParameters;
import com.github.d3a.engine.core.exception.EngineServiceEntityExploreException;
import com.github.d3a.engine.core.exception.EngineServiceRuntimeException;
import com.github.d3a.engine.core.term.Entity;

import java.util.List;
import java.util.Set;

public interface GeospatialScaleCalculable {

    /**
     * 空间拓扑关系定义
     * A  ->  B
     * Contains : 包含,几何形状B的线都在几何形状A内部（区别于内含�?
     * Intersects : 相交,几何形状至少有一个共有点（区别于脱节�?
     * Within : 内含,几何形状A的线都在几何形状B内部
     * Equals : 相等,几何形状拓扑上相�?
     * Crosses : 交叉,几何形状共享一些但不是所有的内部�?
     * Touches : 接触,几何形状有至少一个公共的边界点，但是没有内部�?
     * Overlaps : 重叠,几何形状共享一部分但不是所有的公共点，而且相交处有他们自己相同的区�?
     * Disjoint : 脱节,几何形状没有共有的点
     * Cover : 覆盖, 面状几何形态B的所有部分都在面状几何形态A内部
     * CoveredBy : 被覆�?面状几何形态A的所有部分都在面状几何形态B内部
     */
    public enum SpatialPredicateType {Contains,Intersects,Within,Equals,Crosses,Touches,Overlaps,Disjoint,Cover,CoveredBy}

    /**
     * 空间计算使用的地理空间尺度参考坐标系
     * Global : 全球尺度空间参考坐标系
     * Country : 国家尺度空间参考坐标系
     * Local : 地方尺度空间参考坐标系
     */
    public enum SpatialScaleLevel {Global,Country,Local}

    /**
     * 选择一个概念类型中的若干目标概念实体，与当前概念实体进行平面地理空间计算，并过滤返回符合计算规则的目标概念实体列表
     *
     * @param targetConceptionKind String 执行空间计算的目标概念类型名�?
     * @param attributesParameters AttributesParameters 选择目标概念实体的查询过滤条�?
     * @param spatialPredicateType SpatialPredicateType 空间计算使用的空间拓扑关系类�?
     * @param spatialScaleLevel SpatialScaleLevel 空间计算针对的地理空间尺度坐标系数据
     *
     * @return 符合空间计算规则定义的目标概念实体列�?
     */
    public List<Entity> getSpatialPredicateMatchedConceptionEntities(String targetConceptionKind, AttributesParameters attributesParameters,
                                                                     SpatialPredicateType spatialPredicateType,
                                                                     SpatialScaleLevel spatialScaleLevel) throws EngineServiceRuntimeException, EngineServiceEntityExploreException;
    /**
     * 选择一个概念类型中的若干目标概念实体，与由当前概念实体计算获取的缓冲区进行平面地理空间计算，并过滤返回符合计算规则的目标概念实体列�?
     *
     * @param targetConceptionKind String 执行空间计算的目标概念类型名�?
     * @param attributesParameters AttributesParameters 选择目标概念实体的查询过滤条�?
     * @param bufferDistanceValue double 针对当前概念实体执行计算的缓冲值，其数值的度量单位与所使用的空间坐标系相同
     * @param spatialPredicateType SpatialPredicateType 空间计算使用的空间拓扑关系类�?
     * @param spatialScaleLevel SpatialScaleLevel 空间计算针对的地理空间尺度坐标系数据
     *
     * @return 符合空间计算规则定义的目标概念实体列�?
     */
    public List<Entity> getSpatialBufferMatchedConceptionEntities(String targetConceptionKind, AttributesParameters attributesParameters,
                                                                  double bufferDistanceValue, SpatialPredicateType spatialPredicateType,
                                                                  SpatialScaleLevel spatialScaleLevel) throws EngineServiceRuntimeException, EngineServiceEntityExploreException;
    /**
     * 选择一个目标概念实体，与当前概念实体进行平面地理空间计�?
     *
     * @param spatialPredicateType SpatialPredicateType 空间计算使用的空间拓扑关系类�?
     * @param targetEntityUID String 目标概念实体的唯一ID
     * @param spatialScaleLevel SpatialScaleLevel 空间计算针对的地理空间尺度坐标系数据
     *
     * @return 空间计算的计算结�?
     */
    public boolean isSpatialPredicateMatchedWith(SpatialPredicateType spatialPredicateType,String targetEntityUID,
                                                 SpatialScaleLevel spatialScaleLevel) throws EngineServiceRuntimeException;

    /**
     * 选择一组目标概念实体，并形成一个单一的空间计算目标，与当前概念实体进行平面地理空间计�?
     *
     * @param spatialPredicateType SpatialPredicateType 空间计算使用的空间拓扑关系类�?
     * @param targetEntityUIDsSet Set<String> 目标概念实体唯一ID的集�?
     * @param spatialScaleLevel SpatialScaleLevel 空间计算针对的地理空间尺度坐标系数据
     *
     * @return 空间计算的计算结�?
     */
    public boolean isSpatialPredicateMatchedWith(SpatialPredicateType spatialPredicateType, Set<String> targetEntityUIDsSet,
                                                 SpatialScaleLevel spatialScaleLevel) throws EngineServiceRuntimeException;

    /**
     * 获取当前概念实体的WKT结构空间数据类型
     *
     * @param spatialScaleLevel SpatialScaleLevel 空间计算针对的地理空间尺度坐标系数据
     *
     * @return 指定地理空间尺度坐标系下的WKT结构空间数据类型
     */
    public GeospatialScaleFeatureSupportable.WKTGeometryType getEntityGeometryType(SpatialScaleLevel spatialScaleLevel) throws EngineServiceRuntimeException;

    /**
     * 选择一个目标概念实体，与当前概念实体进行平面地理空间距离计�?
     *
     * @param targetEntityUID String 目标概念实体的唯一ID
     * @param spatialScaleLevel SpatialScaleLevel 空间计算针对的地理空间尺度坐标系数据
     *
     * @return 空间距离计算的结果，其数值的度量单位与所使用的空间坐标系相同
     */
    public double getEntitiesSpatialDistance(String targetEntityUID, SpatialScaleLevel spatialScaleLevel) throws EngineServiceRuntimeException;

    /**
     * 选择一个目标概念实体，计算其是否与当前概念实体在指定的空间距离之内
     *
     * @param targetEntityUID String 目标概念实体的唯一ID
     * @param distanceValue double 空间距离计算的最大目标数值，其数值的度量单位与所使用的空间坐标系相同
     * @param spatialScaleLevel SpatialScaleLevel 空间计算针对的地理空间尺度坐标系数据
     *
     * @return 如空间距离计算的结果在空间距离计算的最大目标数值之内则返回 true
     */
    public boolean isSpatialDistanceWithinEntity(String targetEntityUID, double distanceValue, SpatialScaleLevel spatialScaleLevel) throws EngineServiceRuntimeException;

    /**
     * 选择一组目标概念实体，并形成一个单一的空间计算目标，计算其是否与当前概念实体在指定的空间距离之内
     *
     * @param targetEntityUIDsSet Set<String> 目标概念实体唯一ID的集�?
     * @param distanceValue double 空间距离计算的最大目标数值，其数值的度量单位与所使用的空间坐标系相同
     * @param spatialScaleLevel SpatialScaleLevel 空间计算针对的地理空间尺度坐标系数据
     *
     * @return 如空间距离计算的结果在空间距离计算的最大目标数值之内则返回 true
     */
    public boolean isSpatialDistanceWithinEntities(Set<String> targetEntityUIDsSet, double distanceValue, SpatialScaleLevel spatialScaleLevel) throws EngineServiceRuntimeException;

    /**
     * 获取由当前概念实体计算缓冲区获得�?WKT结构空间数据文本
     *
     * @param bufferDistanceValue double 针对当前概念实体执行计算的缓冲值，其数值的度量单位与所使用的空间坐标系相同
     * @param spatialScaleLevel SpatialScaleLevel 空间计算针对的地理空间尺度坐标系数据
     *
     * @return 计算结果缓冲区（面状）WKT的文本表�?
     */
    public String getEntitySpatialBufferWKTGeometryContent(double bufferDistanceValue,SpatialScaleLevel spatialScaleLevel) throws EngineServiceRuntimeException;

    /**
     * 获取由当前概念实体计�?Envelope 获得�?WKT结构空间数据文本
     *
     * @param spatialScaleLevel SpatialScaleLevel 空间计算针对的地理空间尺度坐标系数据
     *
     * @return 计算结果 Envelope（面状）WKT的文本表�?
     */
    public String getEntitySpatialEnvelopeWKTGeometryContent(SpatialScaleLevel spatialScaleLevel) throws EngineServiceRuntimeException;

    /**
     * 获取由当前概念实体计�?CentroidPoint 获得�?WKT结构空间数据文本
     *
     * @param spatialScaleLevel SpatialScaleLevel 空间计算针对的地理空间尺度坐标系数据
     *
     * @return 计算结果 CentroidPoint（点状）WKT的文本表�?
     */
    public String getEntitySpatialCentroidPointWKTGeometryContent(SpatialScaleLevel spatialScaleLevel) throws EngineServiceRuntimeException;

    /**
     * 获取由当前概念实体计�?InteriorPoint 获得�?WKT结构空间数据文本
     *
     * @param spatialScaleLevel SpatialScaleLevel 空间计算针对的地理空间尺度坐标系数据
     *
     * @return 计算结果 InteriorPoint（点状）WKT的文本表�?
     */
    public String getEntitySpatialInteriorPointWKTGeometryContent(SpatialScaleLevel spatialScaleLevel) throws EngineServiceRuntimeException;
}

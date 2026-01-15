package com.github.d3a.engine.core.feature;

import com.github.d3a.engine.core.exception.EngineServiceRuntimeException;
import com.github.d3a.engine.core.payload.GeospatialScaleDataPair;
import com.github.d3a.engine.core.term.GeospatialScaleEntity;
import com.github.d3a.engine.core.term.GeospatialScaleEvent;

import java.util.List;
import java.util.Map;

public interface GeospatialScaleFeatureSupportable {
    /**
     * WKT 结构的空间数据类�?
     * POINT : 点状数据
     * LINESTRING : 线状数据
     * POLYGON : 面状数据
     * MULTIPOINT : 多点状数�?
     * MULTILINESTRING : 多线状数�?
     * MULTIPOLYGON : 多面状数�?
     * GEOMETRYCOLLECTION : 复杂结构状数�?
     */
    public enum WKTGeometryType {
        POINT,LINESTRING,POLYGON,MULTIPOINT,MULTILINESTRING, MULTIPOLYGON, GEOMETRYCOLLECTION
    }

    /**
     * 获取当前对象的空间数据结�?
     *
     * @return WKTGeometryType
     */
    public WKTGeometryType getGeometryType();

    /**
     * 为当前对象添加或更新空间数据结构
     *
     * @param wKTGeometryType WKTGeometryType 空间数据结构
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean addOrUpdateGeometryType(WKTGeometryType wKTGeometryType);

    /**
     * 获取当前对象的全球尺度空间参考坐标系(CoordinateReferenceSystem) Authority ID
     * 默认值为 EPSG:4326 (WGS-84)
     * @return 空间参考坐标系权威ID
     */
    public String getGlobalCRSAID();

    /**
     * 为当前对象添加或更新全球尺度空间参考坐标系(CoordinateReferenceSystem) Authority ID
     *
     * @param crsAID String 空间参考坐标系权威ID
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean addOrUpdateGlobalCRSAID(String crsAID);

    /**
     * 获取当前对象的国家尺度空间参考坐标系(CoordinateReferenceSystem) Authority ID
     * 默认值为 EPSG:4490 (CGCS2000)
     * @return 空间参考坐标系权威ID
     */
    public String getCountryCRSAID();

    /**
     * 为当前对象添加或更新国家尺度空间参考坐标系(CoordinateReferenceSystem) Authority ID
     *
     * @param crsAID String 空间参考坐标系权威ID
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean addOrUpdateCountryCRSAID(String crsAID);

    /**
     * 获取当前对象的地方尺度空间参考坐标系(CoordinateReferenceSystem) Authority ID
     * @return 空间参考坐标系权威ID
     */
    public String getLocalCRSAID();

    /**
     * 为当前对象添加或更新地方尺度空间参考坐标系(CoordinateReferenceSystem) Authority ID
     *
     * @param crsAID String 空间参考坐标系权威ID
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean addOrUpdateLocalCRSAID(String crsAID);

    /**
     * 获取当前对象�?WKT格式)全球尺度地理空间数据内容 Global Level
     *
     * @return (WKT格式)地理空间数据内容
     */
    public String getGLGeometryContent();

    /**
     * 为当前对象添加或更新(WKT格式)全球尺度地理空间数据内容 Global Level
     *
     * @param wKTContent String (WKT格式)地理空间数据内容
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean addOrUpdateGLGeometryContent(String wKTContent);

    /**
     * 获取当前对象�?WKT格式)国家尺度地理空间数据内容 Country Level
     *
     * @return (WKT格式)地理空间数据内容
     */
    public String getCLGeometryContent();

    /**
     * 为当前对象添加或更新(WKT格式)国家尺度地理空间数据内容 Country Level
     *
     * @param wKTContent String (WKT格式)地理空间数据内容
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean addOrUpdateCLGeometryContent(String wKTContent);

    /**
     * 获取当前对象�?WKT格式)地方尺度地理空间数据内容 Local Level
     *
     * @return (WKT格式)地理空间数据内容
     */
    public String getLLGeometryContent();

    /**
     * 为当前对象添加或更新(WKT格式)地方尺度地理空间数据内容 Local Level
     *
     * @param wKTContent String (WKT格式)地理空间数据内容
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean addOrUpdateLLGeometryContent(String wKTContent);

    /**
     * 为当前对象在默认地理空间区域上附加地理空间刻度事�?
     *
     * @param geospatialCode String 地理空间刻度实体全局空间编码
     * @param eventComment String 事件备注
     * @param eventData Map<String, Object> 事件数据
     *
     * @return 如操作成功，返回结果为相应地理空间刻度事�?
     */
    public GeospatialScaleEvent attachGeospatialScaleEvent(String geospatialCode, String eventComment, Map<String, Object> eventData) throws EngineServiceRuntimeException;

    /**
     * 为当前对象在默认地理空间区域上附加地理空间刻度事�?
     *
     * @param geospatialRegionName String 指定地理空间区域名称
     * @param geospatialCode String 地理空间刻度实体全局空间编码
     * @param eventComment String 事件备注
     * @param eventData Map<String, Object> 事件数据
     *
     * @return 如操作成功，返回结果为相应地理空间刻度事�?
     */
    public GeospatialScaleEvent attachGeospatialScaleEvent(String geospatialRegionName,String geospatialCode, String eventComment, Map<String, Object> eventData) throws EngineServiceRuntimeException;

    /**
     * 删除当前对象上关联的指定地理空间刻度事件
     *
     * @param geospatialScaleEventUID String 地理空间刻度事件唯一ID
     *
     * @return 如操作成功，返回 true
     */
    public boolean detachGeospatialScaleEvent(String geospatialScaleEventUID) throws EngineServiceRuntimeException;

    /**
     * 获取当前对象上关联的所有地理空间刻度事�?
     *
     * @return 地理空间刻度事件对象列表
     */
    public List<GeospatialScaleEvent> getAttachedGeospatialScaleEvents();

    /**
     * 获取当前对象上关联的所有地理空间刻度实�?
     *
     * @return 地理空间刻度实体对象列表
     */
    public List<GeospatialScaleEntity> getAttachedGeospatialScaleEntities();

    /**
     * 获取当前对象上关联的所有地理空间刻度数据对
     *
     * @return 地理空间刻度数据对对象列�?
     */
    public List<GeospatialScaleDataPair> getAttachedGeospatialScaleDataPairs();
}

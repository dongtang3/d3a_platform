package com.github.d3a.engine.core.feature;

import com.github.d3a.engine.core.exception.EngineServiceRuntimeException;
import com.github.d3a.engine.core.payload.AttributeValue;

import java.math.BigDecimal;
import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AttributesMeasurable {
    /**
     * 删除当前对象中包含的属性信�?
     *
     * @param attributeName String 需要删除的属性名�?
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean removeAttribute(String attributeName) throws EngineServiceRuntimeException;

    /**
     * 获取当前对象中包含的所有属性信�?
     *
     * @return 属性信息值列�?
     */
    public List<AttributeValue> getAttributes();

    /**
     * 判断当前对象中是否包含的特定的属性信�?
     *
     * @param attributeName String 需要判断的属性名�?
     *
     * @return 如包含该属性，返回结果�?true
     */
    public boolean hasAttribute(String attributeName);

    /**
     * 获取当前对象中包含的所有属性名�?
     *
     * @return 属性名称列�?
     */
    public List<String> getAttributeNames();

    /**
     * 获取当前对象中包含的指定属性信息�?
     *
     * @param attributeName String 需要获取的属性名�?
     *
     * @return 属性信息�?
     */
    public AttributeValue getAttribute(String attributeName);

    /**
     * 在当前对象中添加 boolean 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue boolean 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, boolean attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 int 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue int 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, int attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 short 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue short 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, short attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 long 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue long 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, long attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 float 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue float 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, float attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 double 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue double 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, double attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 Date(对应 TimeStamp) 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue Date 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, Date attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 LocalDateTime(对应 DateTime) 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue LocalDateTime 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, LocalDateTime attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 LocalDate(对应 Date) 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue LocalDate 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, LocalDate attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 LocalTime(对应 Time) 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue LocalTime 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, LocalTime attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 String 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue String 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, String attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 byte 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue byte 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, byte attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 BigDecimal 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue BigDecimal 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, BigDecimal attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 Boolean[] 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue Boolean[] 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, Boolean[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 Integer[] 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue Integer[] 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, Integer[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 Short[] 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue Short[] 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, Short[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 Long[] 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue Long[] 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, Long[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 Float[] 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue Float[] 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, Float[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 Double[] 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue Double[] 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, Double[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 Date[] 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue Date[] 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, Date[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 LocalDateTime[] 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue LocalDateTime[] 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, LocalDateTime[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 LocalDate[] 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue LocalDate[] 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, LocalDate[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 LocalTime[] 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue LocalTime[] 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, LocalTime[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 String[] 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue String[] 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, String[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 Byte[] 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue Byte[] 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, Byte[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 BigDecimal[] 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue BigDecimal[] 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, BigDecimal[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加 byte[] 类型的属性信�?
     *
     * @param attributeName String 需要添加的属性名�?
     * @param attributeValue byte[] 需要添加的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue addAttribute(String attributeName, byte[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 boolean 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue boolean 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, boolean attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 int 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue int 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, int attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 short 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue short 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, short attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 long 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue long 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, long attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 float 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue float 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, float attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 double 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue double 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, double attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 Date 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue Date 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, Date attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 LocalDateTime 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue LocalDateTime 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, LocalDateTime attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 LocalDate 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue LocalDate 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, LocalDate attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 LocalTime 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue LocalTime 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, LocalTime attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 String 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue String 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, String attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 byte 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue byte 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, byte attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 BigDecimal 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue BigDecimal 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, BigDecimal attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 Boolean[] 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue Boolean[] 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, Boolean[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 Integer[] 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue Integer[] 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, Integer[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 Short[] 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue Short[] 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, Short[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 Long[] 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue Long[] 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, Long[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 Float[] 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue Float[] 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, Float[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 Double[] 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue Double[] 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, Double[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 Date[] 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue Date[] 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, Date[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 LocalDateTime[] 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue LocalDateTime[] 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, LocalDateTime[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 LocalDate[] 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue LocalDate[] 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, LocalDate[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 LocalTime[] 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue LocalTime[] 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, LocalTime[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 String[] 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue String[] 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, String[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 Byte[] 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue Byte[] 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, Byte[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 BigDecimal[] 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue BigDecimal[] 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, BigDecimal[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 更新当前对象中已有的 byte[] 类型的属性信息�?
     *
     * @param attributeName String 需要更新的属性名�?
     * @param attributeValue byte[] 新的属性�?
     *
     * @return 新建的属性信息�?
     */
    public AttributeValue updateAttribute(String attributeName, byte[] attributeValue) throws EngineServiceRuntimeException;

    /**
     * 在当前对象中添加多个属性信�?
     *
     * @param properties Map<String,Object> 需要添加的属性信息键值对
     *
     * @return 添加成功的属性名称列�?
     */
    public List<String> addAttributes(Map<String,Object> properties);

    /**
     * 更新当前对象中已有的多个属性信�?
     *
     * @param properties Map<String,Object> 需要更新的属性信息键值对
     *
     * @return 更新成功的属性名称列�?
     */
    public List<String> updateAttributes(Map<String,Object> properties);

    /**
     * 在当前对象中添加多个属性信息，如果该属性存在，则执行更新操�?
     *
     * @param properties Map<String,Object> 需要添加或更新的属性信息键值对
     *
     * @return 操作成功的属性名称列�?
     */
    public List<String> addNewOrUpdateAttributes(Map<String, Object> properties);
}

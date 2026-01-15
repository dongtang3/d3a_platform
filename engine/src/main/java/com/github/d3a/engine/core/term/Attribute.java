package com.github.d3a.engine.core.term;

import com.github.d3a.engine.core.feature.ClassificationAttachable;
import com.github.d3a.engine.core.feature.MetaAttributeFeatureSupportable;
import com.github.d3a.engine.core.feature.MetaConfigItemFeatureSupportable;

import java.util.List;

public interface Attribute extends MetaConfigItemFeatureSupportable, MetaAttributeFeatureSupportable, ClassificationAttachable {
    /**
     * 获取当前属性类型对象名�?
     *
     * @return 属性类型对象名�?
     */
    public String getAttributeKindName();

    /**
     * 获取当前属性类型对象唯一ID
     *
     * @return 属性类型对象唯一ID
     */
    public String getAttributeKindUID();

    /**
     * 获取当前属性类型对象描�?
     *
     * @return 属性类型对象描�?
     */
    public String getAttributeKindDesc();

    /**
     * 更新当前属性类型对象描�?
     *
     * @param kindDesc String 新的属性类型描�?
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean updateAttributeKindDesc(String kindDesc);

    /**
     * 获取当前属性类型对象数据类�?数据类型可能选项是：
     * BOOLEAN,INT,SHORT,LONG,FLOAT,DOUBLE,DATE,STRING,BYTE,DECIMAL,
     * BOOLEAN_ARRAY,INT_ARRAY,SHORT_ARRAY,LONG_ARRAY,FLOAT_ARRAY,DOUBLE_ARRAY,DATE_ARRAY,STRING_ARRAY,BYTE_ARRAY,DECIMAL_ARRAY,
     * BINARY
     * @return 属性类型对象数据类型枚举�?
     */
    public AttributeDataType getAttributeDataType();

    /**
     * 获取所有包含当前属性类型的属性视图类型对�?
     *
     * @return 属性视图类型对象列�?
     */
    public List<AttributesView> getContainerAttributesViewKinds();
}

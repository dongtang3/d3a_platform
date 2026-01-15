package com.github.d3a.engine.core.term;

import com.github.d3a.engine.core.analysis.query.QueryParameters;
import com.github.d3a.engine.core.exception.EngineServiceEntityExploreException;
import com.github.d3a.engine.core.exception.EngineServiceRuntimeException;
import com.github.d3a.engine.core.feature.AttributesMeasurable;
import com.github.d3a.engine.core.feature.MetaAttributeFeatureSupportable;
import com.github.d3a.engine.core.structure.InheritanceTree;

import java.util.List;

public interface Classification extends MetaAttributeFeatureSupportable, AttributesMeasurable {
    /**
     * 获取当前分类名称
     *
     * @return 分类名称
     */
    public String getClassificationName();

    /**
     * 获取当前分类描述
     *
     * @return 分类描述
     */
    public String getClassificationDesc();

    /**
     * 更新当前分类描述
     *
     * @param classificationDesc String 新的分类描述
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean updateClassificationDesc(String classificationDesc);

    /**
     * 判断当前分类是否为根节点分类
     *
     * @return 如果当前分类没有父分类则返回 true
     */
    public boolean isRootClassification();

    /**
     * 获取当前分类的父分类
     *
     * @return 父分类对�?
     */
    public Classification getParentClassification();

    /**
     * 获取当前分类的子分类列表
     *
     * @return 子分类对象列�?
     */
    public List<Classification> getChildClassifications();

    /**
     * 获取当前分类的所有后代分�?
     *
     * @return 分类对象继承�?
     */
    public InheritanceTree<Classification> getOffspringClassifications();

    /**
     * 为当前分类附加已经存在的子分�?
     *
     * @param childClassificationName String 需要附加的子分类名�?
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean attachChildClassification(String childClassificationName) throws EngineServiceRuntimeException;

    /**
     * 从当前分类上移除已经附加的子分类的父子关�?
     *
     * @param childClassificationName String 需要移除父子关系的子分类名�?
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean detachChildClassification(String childClassificationName) throws EngineServiceRuntimeException;

    /**
     * 为当前分类创建新的子分类
     *
     * @param classificationName String 新建的子分类名称
     * @param classificationDesc String 新建的子分类描述
     *
     * @return 新建的子分类对象
     */
    public Classification createChildClassification(String classificationName,String classificationDesc) throws EngineServiceRuntimeException;

    /**
     * 删除当前分类的子分类
     *
     * @param classificationName String 需要删除的子分类名�?
     *
     * @return 如操作成功，返回结果�?true
     */
    public boolean removeChildClassification(String classificationName) throws EngineServiceRuntimeException;

    /**
     * 获取与当前分类关联的概念分类对象
     *
     * @param relationKindName String 关联的关系类型名�?
     * @param direction Direction 关联的关系方�?
     * @param includeOffspringClassifications boolean 是否获取后代分类关联的数�?
     * @param offspringLevel int 包含的后代分类层级数
     *
     * @return 概念分类对象列表
     */
    public List<Type> getRelatedConceptionKind(String relationKindName, Direction direction, boolean includeOffspringClassifications, int offspringLevel) throws EngineServiceRuntimeException;

    /**
     * 获取与当前分类关联的关系分类对象
     *
     * @param relationKindName String 关联的关系类型名�?
     * @param direction Direction 关联的关系方�?
     * @param includeOffspringClassifications boolean 是否获取后代分类关联的数�?
     * @param offspringLevel int 包含的后代分类层级数
     *
     * @return 关系分类对象列表
     */
    public List<RelationshipType> getRelatedRelationKind(String relationKindName, Direction direction, boolean includeOffspringClassifications, int offspringLevel) throws EngineServiceRuntimeException;

    /**
     * 获取与当前分类关联的属性类型对�?
     *
     * @param relationKindName String 关联的关系类型名�?
     * @param direction Direction 关联的关系方�?
     * @param includeOffspringClassifications boolean 是否获取后代分类关联的数�?
     * @param offspringLevel int 包含的后代分类层级数
     *
     * @return 属性类型对象列�?
     */
    public List<Attribute> getRelatedAttributeKind(String relationKindName, Direction direction, boolean includeOffspringClassifications, int offspringLevel) throws EngineServiceRuntimeException;

    /**
     * 获取与当前分类关联的属性视图类型对�?
     *
     * @param relationKindName String 关联的关系类型名�?
     * @param direction Direction 关联的关系方�?
     * @param includeOffspringClassifications boolean 是否获取后代分类关联的数�?
     * @param offspringLevel int 包含的后代分类层级数
     *
     * @return 属性视图类型对象列�?
     */
    public List<AttributesView> getRelatedAttributesViewKind(String relationKindName, Direction direction, boolean includeOffspringClassifications, int offspringLevel) throws EngineServiceRuntimeException;

    /**
     * 获取与当前分类关联的概念实体对象
     *
     * @param relationKindName String 关联的关系类型名�?
     * @param direction Direction 关联的关系方�?
     * @param queryParameters QueryParameters 概念实体查询过滤条件
     * @param includeOffspringClassifications boolean 是否获取后代分类关联的数�?
     * @param offspringLevel int 包含的后代分类层级数
     *
     * @return 概念实体对象列表
     */
    public List<Entity> getRelatedEntity(String relationKindName, Direction direction, QueryParameters queryParameters, boolean includeOffspringClassifications, int offspringLevel) throws EngineServiceRuntimeException, EngineServiceEntityExploreException;
}

package com.github.d3a.engine.core.term;

import com.github.d3a.engine.core.analysis.query.AttributesParameters;
import com.github.d3a.engine.core.analysis.query.QueryParameters;
import com.github.d3a.engine.core.payload.EntitiesRetrieveResult;
import com.github.d3a.engine.core.payload.TimeScaleEventsRetrieveResult;
import com.github.d3a.engine.core.structure.InheritanceTree;

import java.util.LinkedList;

public interface TimeScaleEntity {
    /**
     * 时间刻度层级
     * SELF : 表示当前时间刻度实体自身
     * CHILD : 表示当前时间刻度实体下一层级
     * OFFSPRING : 表示当前时间刻度实体所有后代层�?
     */
    public enum TimeScaleLevel {SELF,CHILD,OFFSPRING}

    /**
     * 获取当前时间刻度实体对象的时间刻度等�?
     *
     * @return 时间刻度等级
     */
    public TimeFlow.TimeScaleGrade getTimeScaleGrade();

    /**
     * 获取当前时间刻度实体对象本身最小粒度的绝对数值（例如2015年为 2015, 2015�?�?0日为 20�?
     *
     * @return 当前时间刻度实体对象的绝对�?
     */
    public int getEntityValue();

    /**
     * 获取当前对象的上一级时间刻度实体对�?
     *
     * @return 上一级时间刻度实体对�?
     */
    public TimeScaleEntity getParentEntity();

    /**
     * 获取当前对象同一时间刻度等级中下一个时间刻度实体，例如2011�?月的下一个同级实体为2011�?月，2015�?2月的下一个同级实体为2016�?�?
     *
     * @return 下一个时间刻度实体对�?
     */
    public TimeScaleEntity getNextSameScaleEntity();

    /**
     * 获取当前对象同一时间刻度等级中上一个时间刻度实体，例如2011�?月的上一个同级实体为2011�?月，2016�?月的上一个同级实体为2015�?2�?
     *
     * @return 上一个时间刻度实体对�?
     */
    public TimeScaleEntity getPreviousSameScaleEntity();

    /**
     * 获取当前对象同一时间刻度中的所有同一上层对象的时间刻度实体列表，例如2011�?月对应的同级时间�?011�?月至2011�?2�?
     *
     * @return 同一上层对象的时间刻度实体列�?
     */
    public LinkedList<TimeScaleEntity> getFellowEntities();

    /**
     * 获取当前对象的所有下一级时间刻度中的时间刻度实体列表，例如2011�?月对应的下级时间�?011�?�?日至2011�?�?1�?
     *
     * @return 所有下一级时间刻度的时间刻度实体列表
     */
    public LinkedList<TimeScaleEntity> getChildEntities();

    /**
     * 获取当前对象的第一个下一级时间刻度中的时间刻度实体，例如2011�?月对应值为2011�?�?�?
     *
     * @return 第一个下一级时间刻度中的时间刻度实体对�?
     */
    public TimeScaleEntity getFirstChildEntity();

    /**
     * 获取当前对象的最后一个下一级时间刻度中的时间刻度实体，例如2011�?月对应值为2011�?�?1�?
     *
     * @return 最后一个下一级时间刻度中的时间刻度实体对�?
     */
    public TimeScaleEntity getLastChildEntity();

    /**
     * 遍历获取当前对象的所有后代时间刻度实�?
     *
     * @return 所有后代时间刻度实体构成的继承�?
     */
    public InheritanceTree<TimeScaleEntity> getOffspringEntities();

    /**
     * 获取当前时间刻度实体对象上附着的时间刻度事件的数量
     *
     * @param attributesParameters AttributesParameters 时间刻度事件查询条件
     * @param isDistinctMode boolean 是否剔除重复返回�?
     * @param timeScaleLevel TimeScaleLevel 目标时间刻度等级，如 SELF只返回自身关联事件，CHILD返回包含下一级时间刻度实体关联的事件，OFFSPRING返回包含所有后代时间刻度实体关联的事件
     *
     * @return 时间刻度事件数量
     */
    public Long countAttachedTimeScaleEvents(AttributesParameters attributesParameters, boolean isDistinctMode, TimeScaleLevel timeScaleLevel);

    /**
     * 获取当前时间刻度实体对象上附着的时间刻度事�?
     *
     * @param queryParameters QueryParameters 时间刻度事件查询条件
     * @param timeScaleLevel TimeScaleLevel 目标时间刻度等级，如 SELF只返回自身关联事件，CHILD返回包含下一级时间刻度实体关联的事件，OFFSPRING返回包含所有后代时间刻度实体关联的事件
     *
     * @return 时间刻度事件返回结果�?
     */
    public TimeScaleEventsRetrieveResult getAttachedTimeScaleEvents(QueryParameters queryParameters, TimeScaleLevel timeScaleLevel);

    /**
     * 获取当前时间刻度实体对象上附着的常规概念实体的数量
     *
     * @param timeScaleLevel TimeScaleLevel 目标时间刻度等级，如 SELF只返回自身关联事件，CHILD返回包含下一级时间刻度实体关联的事件，OFFSPRING返回包含所有后代时间刻度实体关联的事件
     *
     * @return 常规概念实体的数�?
     */
    public Long countAttachedConceptionEntities(TimeScaleLevel timeScaleLevel);

    /**
     * 获取当前时间刻度实体对象上附着的常规概念实体的数量
     *
     * @param conceptionKindName String 目标概念类型名称
     * @param attributesParameters AttributesParameters 概念实体查询条件
     * @param isDistinctMode boolean 是否剔除重复返回�?
     * @param timeScaleLevel TimeScaleLevel 目标时间刻度等级，如 SELF只返回自身关联事件，CHILD返回包含下一级时间刻度实体关联的事件，OFFSPRING返回包含所有后代时间刻度实体关联的事件
     *
     * @return 常规概念实体的数�?
     */
    public Long countAttachedConceptionEntities(String conceptionKindName,AttributesParameters attributesParameters, boolean isDistinctMode, TimeScaleLevel timeScaleLevel);

    /**
     * 获取当前时间刻度实体对象上附着的常规概念实体对�?
     *
     * @param conceptionKindName String 目标概念类型名称
     * @param queryParameters QueryParameters 概念实体查询条件
     * @param timeScaleLevel TimeScaleLevel 目标时间刻度等级，如 SELF只返回自身关联事件，CHILD返回包含下一级时间刻度实体关联的事件，OFFSPRING返回包含所有后代时间刻度实体关联的事件
     *
     * @return 概念实体返回结果�?
     */
    public EntitiesRetrieveResult getAttachedConceptionEntities(String conceptionKindName, QueryParameters queryParameters, TimeScaleLevel timeScaleLevel);
}

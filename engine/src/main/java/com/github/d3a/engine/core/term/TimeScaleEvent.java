package com.github.d3a.engine.core.term;

import com.github.d3a.engine.core.feature.AttributesMeasurable;
import com.github.d3a.engine.core.feature.ClassificationAttachable;
import com.github.d3a.engine.core.feature.MultiConceptionKindsSupportable;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeScaleEvent extends AttributesMeasurable, ClassificationAttachable, MultiConceptionKindsSupportable {
    /**
     * 获取当前时间刻度事件所属的时间流名�?
     *
     * @return 时间流名�?
     */
    public String getTimeFlowName();

    /**
     * 获取当前时间刻度事件发生的时间�?
     *
     * @return 时间�?
     */
    public LocalDateTime getReferTime();

    /**
     * 获取当前时间刻度事件的时间刻度等�?
     *
     * @return 时间刻度等级
     */
    public TimeFlow.TimeScaleGrade getTimeScaleGrade();

    /**
     * 获取当前时间刻度事件的唯一ID
     *
     * @return 时间刻度事件唯一ID
     */
    public String getTimeScaleEventUID();

    /**
     * 获取当前时间刻度事件的事件备�?
     *
     * @return 时间刻度事件事件备注
     */
    public String getEventComment();

    /**
     * 获取当前时间刻度事件相关的时间刻度实�?
     *
     * @return 时间刻度实体对象
     */
    public TimeScaleEntity getReferTimeScaleEntity();

    /**
     * 获取当前时间刻度事件相关的常规概念实�?
     *
     * @return 常规概念实体对象
     */
    public Entity getAttachEntity();

    /**
     * 获取当前时间刻度事件的概念类型别名列�?
     *
     * @return 概念类型别名列表
     */
    public List<String> getAliasConceptionKindNames();
}

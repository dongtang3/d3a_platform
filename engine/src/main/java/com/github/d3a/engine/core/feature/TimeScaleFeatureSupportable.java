package com.github.d3a.engine.core.feature;

import com.github.d3a.engine.core.exception.EngineServiceRuntimeException;
import com.github.d3a.engine.core.payload.TimeScaleDataPair;
import com.github.d3a.engine.core.term.TimeScaleEntity;
import com.github.d3a.engine.core.term.TimeScaleEvent;
import com.github.d3a.engine.core.term.TimeFlow;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface TimeScaleFeatureSupportable {
    /**
     * 为当前对象在默认时间流上附加时间刻度事件
     *
     * @param dateTime long 事件发生时间
     * @param eventComment String 事件备注
     * @param eventData Map<String, Object> 事件数据
     * @param timeScaleGrade TimeFlow.TimeScaleGrade 事件时间刻度
     *
     * @return 如操作成功，返回结果为相应时间刻度事件对�?
     */
    public TimeScaleEvent attachTimeScaleEvent(long dateTime, String eventComment, Map<String, Object> eventData,
                                               TimeFlow.TimeScaleGrade timeScaleGrade) throws EngineServiceRuntimeException;

    /**
     * 为当前对象在指定时间流上附加时间刻度事件
     *
     * @param timeFlowName String 指定时间流名�?
     * @param dateTime long 事件发生时间
     * @param eventComment String 事件备注
     * @param eventData Map<String, Object> 事件数据
     * @param timeScaleGrade TimeFlow.TimeScaleGrade 事件时间刻度
     *
     * @return 如操作成功，返回结果为相应时间刻度事件对�?
     */
    public TimeScaleEvent attachTimeScaleEvent(String timeFlowName,long dateTime, String eventComment,
                                               Map<String, Object> eventData, TimeFlow.TimeScaleGrade timeScaleGrade) throws EngineServiceRuntimeException;

    /**
     * 为当前对象在默认时间流上附加时间刻度事件
     *
     * @param dateTime LocalDateTime 事件发生时间
     * @param eventComment String 事件备注
     * @param eventData Map<String, Object> 事件数据
     * @param timeScaleGrade TimeFlow.TimeScaleGrade 事件时间刻度
     *
     * @return 如操作成功，返回结果为相应时间刻度事件对�?
     */
    public TimeScaleEvent attachTimeScaleEvent(LocalDateTime dateTime, String eventComment, Map<String, Object> eventData,
                                               TimeFlow.TimeScaleGrade timeScaleGrade) throws EngineServiceRuntimeException;

    /**
     * 为当前对象在指定时间流上附加时间刻度事件
     *
     * @param timeFlowName String 指定时间流名�?
     * @param dateTime LocalDateTime 事件发生时间
     * @param eventComment String 事件备注
     * @param eventData Map<String, Object> 事件数据
     * @param timeScaleGrade TimeFlow.TimeScaleGrade 事件时间刻度
     *
     * @return 如操作成功，返回结果为相应时间刻度事件对�?
     */
    public TimeScaleEvent attachTimeScaleEvent(String timeFlowName,LocalDateTime dateTime, String eventComment,
                                               Map<String, Object> eventData, TimeFlow.TimeScaleGrade timeScaleGrade) throws EngineServiceRuntimeException;

    /**
     * 为当前对象在默认时间流上附加 TimeScaleGrade.DAY 粒度的时间刻度事�?
     *
     * @param date LocalDate 事件发生日期
     * @param eventComment String 事件备注
     * @param eventData Map<String, Object> 事件数据
     *
     * @return 如操作成功，返回结果为相应时间刻度事件对�?
     */
    public TimeScaleEvent attachTimeScaleEvent(LocalDate date, String eventComment, Map<String, Object> eventData) throws EngineServiceRuntimeException;

    /**
     * 为当前对象在指定时间流上附加时间刻度事件
     *
     * @param timeFlowName String 指定时间流名�?
     * @param date LocalDate 事件发生日期
     * @param eventComment String 事件备注
     * @param eventData Map<String, Object> 事件数据
     *
     * @return 如操作成功，返回结果为相应时间刻度事件对�?
     */
    public TimeScaleEvent attachTimeScaleEvent(String timeFlowName,LocalDate date, String eventComment,
                                               Map<String, Object> eventData) throws EngineServiceRuntimeException;

    /**
     * 删除当前对象上关联的指定时间刻度事件
     *
     * @param timeScaleEventUID String 时间刻度事件唯一ID
     *
     * @return 如操作成功，返回 true
     */
    public boolean detachTimeScaleEvent(String timeScaleEventUID) throws EngineServiceRuntimeException;

    /**
     * 获取当前对象上关联的所有时间刻度事�?
     *
     * @return 时间刻度事件对象列表
     */
    public List<TimeScaleEvent> getAttachedTimeScaleEvents();

    /**
     * 获取当前对象上关联的所有时间刻度实�?
     *
     * @return 时间刻度实体对象列表
     */
    public List<TimeScaleEntity> getAttachedTimeScaleEntities();

    /**
     * 获取当前对象上关联的所有时间刻度数据对
     *
     * @return 时间刻度数据对对象列�?
     */
    public List<TimeScaleDataPair> getAttachedTimeScaleDataPairs();
}

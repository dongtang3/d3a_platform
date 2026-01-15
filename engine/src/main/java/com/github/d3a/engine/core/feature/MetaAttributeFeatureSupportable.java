package com.github.d3a.engine.core.feature;

import java.util.Date;

public interface MetaAttributeFeatureSupportable {
    /**
     * 获取当前对象创建时间
     *
     * @return 创建时间
     */
    Date getCreateDateTime();

    /**
     * 获取当前对象最后更新时�?
     *
     * @return 最后更新时�?
     */
    Date getLastModifyDateTime();

    /**
     * 获取当前对象创建人ID
     *
     * @return 创建人ID
     */
    String getCreatorId();

    /**
     * 获取当前对象数据原始来源
     *
     * @return 数据原始来源
     */
    String getDataOrigin();

    /**
     * 更新当前对象最后更新时�?
     *
     * @return 如操作成功，返回结果�?true
     */
    boolean updateLastModifyDateTime();

    /**
     * 更新当前对象创建人ID
     *
     * @param creatorId String 新的创建人ID
     *
     * @return 如操作成功，返回结果�?true
     */
    boolean updateCreatorId(String creatorId);

    /**
     * 更新当前对象数据原始来源
     *
     * @param dataOrigin String 新的数据原始来源
     *
     * @return 如操作成功，返回结果�?true
     */
    boolean updateDataOrigin(String dataOrigin);
}

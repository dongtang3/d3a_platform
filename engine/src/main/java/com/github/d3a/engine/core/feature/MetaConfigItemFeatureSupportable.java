package com.github.d3a.engine.core.feature;

import java.util.*;

public interface MetaConfigItemFeatureSupportable {
    /**
     * 为当前对象添加自定义配置项，如该配置项已经存在，则执行更新操�?
     *
     * @param itemName String 配置项名�?
     * @param itemValue Object 配置项�?
     *
     * @return 如操作成功，返回结果�?true
     */
    boolean addOrUpdateMetaConfigItem(String itemName,Object itemValue);

    /**
     * 获取当前对象的所有自定义配置�?
     *
     * @return 自定义配置项键值对
     */
    Map<String,Object> getMetaConfigItems();

    /**
     * 获取当前对象的指定自定义配置�?
     *
     * @param itemName String 配置项名�?
     *
     * @return 自定义配置项键值对
     */
    Object getMetaConfigItem(String itemName);

    /**
     * 删除当前对象的指定自定义配置�?
     *
     * @param itemName String 配置项名�?
     *
     * @return 如操作成功，返回结果�?true
     */
    boolean deleteMetaConfigItem(String itemName);
}

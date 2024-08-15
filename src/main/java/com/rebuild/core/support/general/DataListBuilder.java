
package com.rebuild.core.support.general;

import cn.devezhao.persist4j.Entity;
import com.alibaba.fastjson.JSON;

/**
 * @author Zhao Fangfang
 * @since 1.0, 2018-6-20
 */
public interface DataListBuilder {

    /**
     * @return
     */
    Entity getEntity();

    /**
     * 默认过滤条件
     *
     * @return
     */
    String getDefaultFilter();

    /**
     * JSON 结果集
     *
     * @return
     */
    JSON getJSONResult();
}

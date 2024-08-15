
package com.rebuild.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;

import java.io.Serializable;

/**
 * Use fastjson
 *
 * @author devezhao zhaofang123@gmail.com
 * @since 2019/06/03
 */
public interface JSONable extends JSONAware, Serializable {

    /**
     * @return
     */
    JSON toJSON();

    /**
     * @param specFields
     * @return
     */
    default JSON toJSON(String... specFields) {
        return toJSON();
    }

    @Override
    default String toJSONString() {
        return JSON.toJSONString(toJSON());
    }
}

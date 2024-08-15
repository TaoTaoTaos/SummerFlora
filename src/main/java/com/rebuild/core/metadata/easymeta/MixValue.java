
package com.rebuild.core.metadata.easymeta;

import com.alibaba.fastjson.JSONObject;

/**
 * 复合值
 *
 * @author devezhao
 * @since 2020/11/17
 */
public interface MixValue {

    /**
     * 获取 Label/Text 人类可识别值
     *
     * @param wrappedValue
     * @return
     */
    default Object unpackWrapValue(Object wrappedValue) {
        if (wrappedValue instanceof JSONObject) {
            return ((JSONObject) wrappedValue).getString("text");
        }
        return null;
    }
}

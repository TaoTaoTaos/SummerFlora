
package com.rebuild.api;

import cn.devezhao.commons.CalendarUtils;
import com.alibaba.fastjson.JSON;
import com.rebuild.utils.JSONUtils;

/**
 * 参考实现。获取系统时间
 *
 * @author devezhao
 * @since 01/10/2019
 */
public class SystemTime extends BaseApi {

    @Override
    public JSON execute(ApiContext context) {
        JSON data = JSONUtils.toJSONObject(
                new String[] { "time" },
                new Object[] { CalendarUtils.now().getTime() });
        return formatSuccess(data);
    }
}

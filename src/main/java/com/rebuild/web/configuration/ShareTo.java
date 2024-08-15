
package com.rebuild.web.configuration;

import cn.devezhao.persist4j.Record;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author devezhao
 * @since 09/17/2020
 */
public interface ShareTo {

    /**
     * 可共享配置公共字段
     *
     * @param request
     * @param record
     */
    default void putCommonsFields(HttpServletRequest request, Record record) {
        String shareTo = request.getParameter("shareTo");
        if (StringUtils.isNotBlank(shareTo)) {
            record.setString("shareTo", shareTo);
        }

        String configName = request.getParameter("configName");
        if (StringUtils.isNotBlank(configName)) {
            record.setString("configName", configName);
        }
    }
}

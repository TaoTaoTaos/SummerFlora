
package com.rebuild.core.service.dashboard.charts;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rebuild.core.support.i18n.Language;
import com.rebuild.utils.RbAssert;

/**
 * 柱状图
 *
 * @author devezhao
 * @since 4/3/2024
 */
public class Bar3Chart extends LineChart {

    protected Bar3Chart(JSONObject config) {
        super(config);
    }

    @Override
    public JSON build() {
        RbAssert.isCommercial(Language.L(" 不支持此图表"));
        return super.build();
    }
}

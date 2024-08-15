
package com.rebuild.core.service.approval;

import com.alibaba.fastjson.JSONObject;
import com.rebuild.core.configuration.ConfigBean;

/**
 * 审批流程定义
 *
 * @author devezhao zhaofang123@gmail.com
 * @since 2019/07/05
 */
public class FlowDefinition extends ConfigBean {
    private static final long serialVersionUID = 9146239943240893998L;

    transient private FlowParser flowParser;

    /**
     * @return
     */
    public boolean isDisabled() {
        return getBoolean("disabled");
    }

    /**
     * @return
     */
    public FlowParser createFlowParser() {
        if (flowParser == null) {
            flowParser = new FlowParser(getJSON("flowDefinition"));
        }
        return flowParser;
    }

    /**
     * @return
     */
    public boolean isWorkable() {
        JSONObject def = (JSONObject) getJSON("flowDefinition");
        return def != null && createFlowParser().hasApproverNode();
    }
}


package com.rebuild.core.service.trigger;

import com.rebuild.core.service.general.OperatingContext;

/**
 * 手动触发，而非通过 ObservableService 规范触发
 *
 * @author devezhao
 * @since 2019/11/22
 */
public class RobotTriggerManual extends RobotTriggerObserver {

    /**
     * 审批通过触发
     *
     * @param context
     */
    public void onApproved(OperatingContext context) {
        execAction(context, TriggerWhen.APPROVED);
    }

    /**
     * 审批撤销触发
     *
     * @param context
     */
    public void onRevoked(OperatingContext context) {
        execAction(context, TriggerWhen.REVOKED);
    }

    /**
     * 审批提交
     *
     * @param context
     */
    public void onSubmit(OperatingContext context) {
        execAction(context, TriggerWhen.SUBMIT);
    }

    /**
     * 审批驳回/撤回
     *
     * @param context
     */
    public void onRejectedOrCancel(OperatingContext context) {
        execAction(context, TriggerWhen.REJECTED);
    }

    // PUBLIC
    @Override
    public void onUpdate(OperatingContext context) {
        super.onUpdate(context);
    }
}

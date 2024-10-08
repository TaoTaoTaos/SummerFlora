
package com.rebuild.core.service.trigger;

import com.rebuild.core.service.DataSpecificationException;

/**
 * 数据校验专用
 *
 * @author devezhao
 * @since 2021/6/30
 * @see com.rebuild.rbv.trigger.DataValidate
 */
public class DataValidateException extends DataSpecificationException {
    private static final long serialVersionUID = 4178910284594338317L;

    private boolean weakMode = false;

    public DataValidateException(String msg) {
        super(msg);
    }

    public DataValidateException(String msg, boolean weakMode) {
        super(msg);
        this.weakMode = weakMode;
    }

    public boolean isWeakMode() {
        return weakMode;
    }
}

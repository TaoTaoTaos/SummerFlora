
package com.rebuild.core.service.trigger.aviator;

import com.googlecode.aviator.runtime.function.system.AssertFunction;
import com.rebuild.core.service.trigger.DataValidateException;

/**
 * @author devezhao
 * @since 2023/4/16
 * @see com.googlecode.aviator.runtime.function.system.AssertFunction.AssertFailed
 */
public class AssertFailedException extends DataValidateException {
    private static final long serialVersionUID = -4785784500930570769L;

    public AssertFailedException(AssertFunction.AssertFailed cause) {
        super(cause.getLocalizedMessage(), Boolean.FALSE);
    }
}

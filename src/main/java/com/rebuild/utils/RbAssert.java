
package com.rebuild.utils;

import com.rebuild.core.DefinedException;
import com.rebuild.core.support.License;
import com.rebuild.core.support.NeedRbvException;
import com.rebuild.core.support.i18n.Language;

/**
 * @author devezhao
 * @since 2020/12/8
 */
public class RbAssert {

    /**
     * @param message
     */
    public static void isCommercial(String message) {
        if (!License.isCommercial()) {
            if (message == null)
                message = Language.L(" 不支持此功能");
            throw new NeedRbvException(message);
        }
    }

    /**
     * @param expression
     * @param message
     * @see #is(boolean, String)
     */
    public static void isAllow(boolean expression, String message) {
        is(expression, message);
    }

    /**
     * @param expression
     * @param message
     */
    public static void is(boolean expression, String message) {
        if (!expression) {
            throw new DefinedException(message);
        }
    }

    /**
     * @param expression
     * @see #is(boolean, String)
     */
    public static void checkAllow(boolean expression) {
        is(expression, "Not Allow");
    }
}

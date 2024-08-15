
package com.rebuild.web;

import com.rebuild.core.DefinedException;

/**
 * 无效请求参数
 *
 * @author Zixin (RB)
 * @since 05/19/2018
 */
public class InvalidParameterException extends DefinedException {
    private static final long serialVersionUID = 1104144276994648297L;

    public InvalidParameterException(String msg) {
        super(msg, null, false, false);
    }
}

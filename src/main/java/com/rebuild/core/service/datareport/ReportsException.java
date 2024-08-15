
package com.rebuild.core.service.datareport;

import com.rebuild.core.RebuildException;

/**
 * @author devezhao
 * @since 2023/8/28
 */
public class ReportsException extends RebuildException {
    private static final long serialVersionUID = -4178242018962437528L;

    public ReportsException(String msg) {
        super(msg);
    }

    public ReportsException(Throwable cause) {
        super(cause);
    }
}

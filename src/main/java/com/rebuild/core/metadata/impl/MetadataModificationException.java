
package com.rebuild.core.metadata.impl;

import com.rebuild.core.RebuildException;

/**
 * 修改元数据异常
 *
 * @author devezhao
 * @since 11/16/2018
 */
public class MetadataModificationException extends RebuildException {
    private static final long serialVersionUID = 1552569207578832059L;

    public MetadataModificationException(String message) {
        super(message);
    }

    public MetadataModificationException(Throwable cause) {
        super(cause);
    }
}

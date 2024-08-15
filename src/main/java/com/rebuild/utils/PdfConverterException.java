
package com.rebuild.utils;

import com.rebuild.core.RebuildException;

/**
 * @author devezhao
 * @since 2023/4/5
 */
public class PdfConverterException extends RebuildException {
    private static final long serialVersionUID = -4178242018962437529L;

    public PdfConverterException(String msg) {
        super(msg);
    }

    public PdfConverterException(Throwable cause) {
        super(cause);
    }
}

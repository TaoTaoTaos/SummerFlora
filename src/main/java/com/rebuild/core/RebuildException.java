
package com.rebuild.core;

/**
 * RB Root Exception
 *
 * @author Zixin (RB)
 * @since 05/19/2018
 */
public class RebuildException extends RuntimeException {
    private static final long serialVersionUID = -889444005870894361L;

    public RebuildException() {
    }

    public RebuildException(String message) {
        super(message);
    }

    public RebuildException(String message, Throwable cause) {
        super(message, cause);
    }

    public RebuildException(Throwable cause) {
        super(cause);
    }

    public RebuildException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

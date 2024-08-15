
package com.rebuild.core.service;

/**
 * 事物不回滚异常
 *
 * @author devezhao
 * @since 2019/9/26
 */
public class DataSpecificationNoRollbackException extends DataSpecificationException {
    private static final long serialVersionUID = 6665988665858333848L;

    public DataSpecificationNoRollbackException() {
        super();
    }

    public DataSpecificationNoRollbackException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DataSpecificationNoRollbackException(String msg) {
        super(msg);
    }

    public DataSpecificationNoRollbackException(Throwable cause) {
        super(cause);
    }

    public DataSpecificationNoRollbackException(int errorCode, String msg) {
        super(errorCode, msg);
    }
}

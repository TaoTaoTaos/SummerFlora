
package com.rebuild.core.service;

/**
 * @author devezhao
 * @since 2021/11/19
 * @see java.util.concurrent.Callable
 */
public interface Callable2<V, T> {

    /**
     * @param argv
     * @return
     */
    V call(T argv);
}

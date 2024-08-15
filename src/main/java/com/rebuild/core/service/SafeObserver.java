
package com.rebuild.core.service;

/**
 * Thread-Safe `Observer`
 *
 * @author devezhao
 * @since 2023/12/22
 */
public interface SafeObserver {

    void update(SafeObservable o, Object arg);

    int getOrder();
}

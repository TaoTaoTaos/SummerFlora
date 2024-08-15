
package com.rebuild.core.support.distributed;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/**
 * 分布式支持
 *
 * @author devezhao
 * @since 2020/9/27
 */
public interface DistributedSupport {

    /**
     * @param namespace
     * @param <K>
     * @param <V>
     * @return
     */
    <K, V> ConcurrentMap<K, V> getMap(String namespace);

    /**
     * @param namespace
     * @param <T>
     * @return
     */
    <T> List<T> getList(String namespace);

    /**
     * @param namespace
     * @param <T>
     * @return
     */
    <T> Set<T> getSet(String namespace);
}


package com.rebuild.core.cache;

import com.rebuild.core.Application;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import java.io.Serializable;

/**
 * Cache for all
 *
 * @author devezhao
 * @since 12/24/2018
 */
@Service
public class CommonsCache extends BaseCacheTemplate<Serializable> {

    protected CommonsCache(JedisPool jedisPool, CacheManager cacheManager) {
        super(jedisPool, cacheManager, null);
    }

    /**
     * @return
     */
    public JedisPool getJedisPool() {
        return ((RedisDriver<?>) Application.getCommonsCache().getCacheTemplate()).getJedisPool();
    }

    /**
     * @return
     */
    public Cache getEhcacheCache() {
        return ((EhcacheDriver<?>) Application.getCommonsCache().getCacheTemplate()).cache();
    }
}

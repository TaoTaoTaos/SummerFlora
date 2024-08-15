
package com.rebuild.core.metadata.impl;

/**
 * 暂不存在的实体
 *
 * @author devezhao
 * @since 2020/9/29
 */
public class GhostEntity extends UnsafeEntity {
    private static final long serialVersionUID = -6972522738044854886L;

    public GhostEntity(String name) {
        super(name, null, null, -1, null);
    }
}

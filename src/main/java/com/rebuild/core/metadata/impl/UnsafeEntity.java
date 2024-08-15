
package com.rebuild.core.metadata.impl;

import cn.devezhao.persist4j.Field;
import cn.devezhao.persist4j.metadata.impl.EntityImpl;

/**
 * 尚未同步到数据库中的实体
 *
 * @author Zixin (RB)
 * @since 08/04/2018
 */
public class UnsafeEntity extends EntityImpl {
    private static final long serialVersionUID = 2107073554299141281L;

    protected UnsafeEntity(String entityName, String physicalName, String entityLabel, int typeCode,
            String nameFieldName) {
        super(entityName, physicalName, entityLabel, null,
                Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, typeCode, nameFieldName, Boolean.TRUE);
    }

    @Override
    protected void addField(Field field) {
        super.addField(field);
    }
}

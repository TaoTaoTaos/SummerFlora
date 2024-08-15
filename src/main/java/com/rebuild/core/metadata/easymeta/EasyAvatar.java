
package com.rebuild.core.metadata.easymeta;

import cn.devezhao.persist4j.Field;
import org.springframework.util.Assert;

/**
 * @author devezhao
 * @since 2020/11/17
 */
public class EasyAvatar extends EasyField {
    private static final long serialVersionUID = 1215127698901482136L;

    protected EasyAvatar(Field field, DisplayType displayType) {
        super(field, displayType);
    }

    @Override
    public Object convertCompatibleValue(Object value, EasyField targetField) {
        Assert.isTrue(targetField.getDisplayType() == getDisplayType(), "type-by-type is must");
        return value;
    }
}


package com.rebuild.core.metadata.easymeta;

import cn.devezhao.persist4j.Field;

/**
 * @author devezhao
 * @since 2020/11/17
 */
public class EasySeries extends EasyField {
    private static final long serialVersionUID = 2947282784021933768L;

    protected EasySeries(Field field, DisplayType displayType) {
        super(field, displayType);
    }

    @Override
    public Object convertCompatibleValue(Object value, EasyField targetField) {
        DisplayType targetType = targetField.getDisplayType();
        boolean is2Text = targetType == DisplayType.TEXT || targetType == DisplayType.NTEXT;
        if (is2Text) {
            return value.toString();
        }

        throw new UnsupportedOperationException();
    }

    @Override
    public Object exprDefaultValue() {
        return null;
    }
}


package com.rebuild.core.metadata.easymeta;

import cn.devezhao.persist4j.Field;

/**
 * @author devezhao
 * @since 2020/11/17
 */
public class EasyNText extends EasyField {
    private static final long serialVersionUID = -3986451731566643240L;

    protected EasyNText(Field field, DisplayType displayType) {
        super(field, displayType);
    }

    @Override
    public Object exprDefaultValue() {
        Object d = super.exprDefaultValue();
        if (d != null)
            d = d.toString().replace("\\n", "\n"); // 换行符
        return d;
    }
}

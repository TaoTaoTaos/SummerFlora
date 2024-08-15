
package com.rebuild.core.support.i18n;

import cn.devezhao.commons.CalendarUtils;
import org.junit.jupiter.api.Test;

/**
 * @author devezhao
 * @since 2020/9/18
 */
public class I18nUtilsTest {

    @Test
    public void formatDate() {
        System.out.println(I18nUtils.formatDate(CalendarUtils.now()));
    }
}
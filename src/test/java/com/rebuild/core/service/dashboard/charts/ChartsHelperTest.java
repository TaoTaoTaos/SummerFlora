
package com.rebuild.core.service.dashboard.charts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ZHAO
 * @since 2020/4/28
 */
public class ChartsHelperTest {

    @Test
    public void isZero() {
        Assertions.assertFalse(ChartsHelper.isZero("123"));
        Assertions.assertTrue(ChartsHelper.isZero(0));
        Assertions.assertTrue(ChartsHelper.isZero(0d));
    }
}
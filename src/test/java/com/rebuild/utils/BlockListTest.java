
package com.rebuild.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author devezhao zhaofang123@gmail.com
 * @since 2019/03/08
 */
public class BlockListTest {

    @Test
    void isBlock() {
        Assertions.assertTrue(BlockList.isBlock("admin"));
        Assertions.assertFalse(BlockList.isBlock("imnotadmin"));
    }
}

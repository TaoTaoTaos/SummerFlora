
package com.rebuild.core.service.feeds;

import cn.devezhao.persist4j.engine.ID;
import com.rebuild.core.metadata.EntityHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ZHAO
 * @since 2019/11/28
 */
public class FeedsConstantTest {

    @Test
    void testFeedsScope() {
        System.out.println(FeedsScope.parse("SELF"));
        System.out.println(FeedsScope.parse(ID.newId(EntityHelper.Team).toLiteral()));
    }

    @Test
    void testFeedsType() {
        System.out.println(FeedsType.parse(1));
    }

    @Test
    void testFeedsType2() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> FeedsType.parse(111));
    }
}

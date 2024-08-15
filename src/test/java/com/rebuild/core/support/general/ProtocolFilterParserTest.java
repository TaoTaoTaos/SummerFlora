
package com.rebuild.core.support.general;

import cn.devezhao.persist4j.engine.ID;
import com.rebuild.TestSupport;
import com.rebuild.core.metadata.EntityHelper;
import org.junit.jupiter.api.Test;

/**
 * @author devezhao
 * @since 2020/6/13
 */
public class ProtocolFilterParserTest extends TestSupport {

    @Test
    public void parseVia() {
        System.out.println(new ProtocolFilterParser()
                .parseVia(ID.newId(EntityHelper.ChartConfig).toLiteral(), null));
    }

    @Test
    public void parseRef() {
        System.out.println(new ProtocolFilterParser()
                .parseRef("REFERENCE.TESTALLFIELDS", null));
    }
}
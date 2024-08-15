
package com.rebuild.core.service.approval;

import cn.devezhao.persist4j.Entity;
import com.rebuild.TestSupport;
import com.rebuild.core.metadata.MetadataHelper;
import org.junit.jupiter.api.Test;

/**
 * @author devezhao-mbp zhaofang123@gmail.com
 * @since 2019/07/04
 */
public class ApprovalFields2SchemaTest extends TestSupport {

    @Test
    public void testCreateFields() {
        Entity test = MetadataHelper.getEntity(TestAllFields);
        boolean created = new ApprovalFields2Schema().createFields(test);
        System.out.println("Fields of approval is created : " + created);
    }
}

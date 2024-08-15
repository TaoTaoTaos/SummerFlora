
package com.rebuild.core.configuration.general;

import cn.devezhao.persist4j.Field;
import com.alibaba.fastjson.JSON;
import com.rebuild.TestSupport;
import com.rebuild.core.metadata.MetadataHelper;
import org.junit.jupiter.api.Test;

/**
 * @author devezhao zhaofang123@gmail.com
 * @since 2019/03/09
 */
public class PickListManagerTest extends TestSupport {

    @Test
    public void testGetPickList() {
        Field picklist = MetadataHelper.getEntity(TestAllFields).getField("picklist");
        JSON list = PickListManager.instance.getPickList(picklist);
        System.out.println(list.toJSONString());
    }
}

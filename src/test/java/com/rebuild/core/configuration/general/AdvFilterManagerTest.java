
package com.rebuild.core.configuration.general;

import com.alibaba.fastjson.JSONArray;
import com.rebuild.TestSupport;
import com.rebuild.core.privileges.UserService;
import org.junit.jupiter.api.Test;

/**
 * @author devezhao zhaofang123@gmail.com
 * @since 2019/03/09
 */
public class AdvFilterManagerTest extends TestSupport {

    @Test
    public void testGetAdvFilterList() {
        JSONArray array = AdvFilterManager.instance.getAdvFilterList("User", UserService.ADMIN_USER);
        System.out.println("AdvFilterManager : " + array);
    }
}

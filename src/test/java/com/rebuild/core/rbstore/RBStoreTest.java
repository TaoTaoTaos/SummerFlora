
package com.rebuild.core.rbstore;

import com.alibaba.fastjson.JSON;
import com.rebuild.TestSupport;
import com.rebuild.utils.JSONUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author devezhao zhaofang123@gmail.com
 * @since 2020/08/18
 */
public class RBStoreTest extends TestSupport {

    @Test
    void fetchMetaschema() {
        JSON data = RBStore.fetchMetaschema("ACCOUNT-1.0.json");
        Assertions.assertNotNull(data);

        System.out.println(JSONUtils.prettyPrint(data));
    }
}
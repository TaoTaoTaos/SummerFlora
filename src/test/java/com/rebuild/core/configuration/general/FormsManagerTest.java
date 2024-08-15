
package com.rebuild.core.configuration.general;

import com.rebuild.TestSupport;
import com.rebuild.core.configuration.ConfigBean;
import org.junit.jupiter.api.Test;

/**
 * @author devezhao
 * @since 01/04/2019
 */
class FormsManagerTest extends TestSupport {

    @Test
    void testGet() {
        ConfigBean f = FormsManager.instance.getNewFormLayout("User");
        System.out.println(f.toJSON());
    }
}

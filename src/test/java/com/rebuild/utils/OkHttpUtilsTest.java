
package com.rebuild.utils;

import org.junit.jupiter.api.Test;

/**
 */
class OkHttpUtilsTest {

    @Test
    void get() throws Exception {
        System.out.println(OkHttpUtils.get("http://webhook.site/844bc39e-3c57-4378-bf0a-66925abc2a1c"));
        System.out.println(
                OkHttpUtils.post("http://webhook.site/844bc39e-3c57-4378-bf0a-66925abc2a1c", "Hello! I'm RB!"));
    }
}
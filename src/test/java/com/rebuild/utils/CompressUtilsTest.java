
package com.rebuild.utils;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 */
class CompressUtilsTest {

    @Test
    void zip() throws IOException {
        CompressUtils.forceZip(
                new File("D:\\GitHub\\rebuild\\rebuild"),
                new File("D:\\GitHub\\rebuild.zip"),
                pathname -> !pathname.getName().contains("node_modules"));
    }
}
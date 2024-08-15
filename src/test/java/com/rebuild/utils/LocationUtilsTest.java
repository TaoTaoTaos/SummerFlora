
package com.rebuild.utils;

import org.junit.jupiter.api.Test;

/**
 */
class LocationUtilsTest {

    @Test
    void getLocation() {
        System.out.println(LocationUtils.getLocation("8.8.8.8"));
        System.out.println(LocationUtils.getLocation("59.82.84.31"));
        System.out.println(LocationUtils.getLocation("192.168.1.1"));
        System.out.println(LocationUtils.getLocation("123"));
    }
}
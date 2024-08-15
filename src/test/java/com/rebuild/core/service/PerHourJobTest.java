
package com.rebuild.core.service;

import com.rebuild.TestSupport;
import org.junit.jupiter.api.Test;

/**
 * @author devezhao
 * @since 2020/11/11
 */
class PerHourJobTest extends TestSupport {

    @Test
    void doCleanTempFiles() {
        new PerHourJob().doCleanTempFiles();
    }

    @Test
    void doCleanExpiredShare() {
        new PerHourJob().doCleanExpiredSharedUrls();
    }
}
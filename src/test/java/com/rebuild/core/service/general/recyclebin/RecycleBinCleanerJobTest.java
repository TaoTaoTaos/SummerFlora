
package com.rebuild.core.service.general.recyclebin;

import com.rebuild.TestSupport;
import org.junit.jupiter.api.Test;

/**
 * @author devezhao
 * @since 2020/2/23
 */
class RecycleBinCleanerJobTest extends TestSupport {

    @Test
    void executeInternal() {
        new RecycleBinCleanerJob().executeJob();
    }
}
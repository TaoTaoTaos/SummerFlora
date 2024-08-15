
package com.rebuild.core.support.setup;

import com.rebuild.TestSupport;
import org.junit.jupiter.api.Test;

/**
 * @author devezhao
 * @since 02/04/2020
 */
class DatabaseBackupTest extends TestSupport {

    @Test
    void backup() throws Exception {
        new DatabaseBackup().backup();
    }

    @Test
    void backupFile() throws Exception {
        new DatafileBackup().backup();
    }
}
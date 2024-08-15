
package com.rebuild.core.support.setup;

import com.rebuild.TestSupport;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author devezhao zhaofang123@gmail.com
 * @since 2019/03/22
 */
public class UpgradeDatabaseTest extends TestSupport {

    @Test
    public void testUpgrade() throws Exception {
        // It's okay
        new UpgradeDatabase().upgrade();
        // It's okay too
        new UpgradeDatabase().upgrade();
    }

    @Test
    public void testRead() throws Exception {
        Map<Integer, String[]> sqls = new UpgradeScriptReader().read();

        int verIdx = 1;
        while (true) {
            String[] sql = sqls.get(verIdx);
            if (sql == null) {
                break;
            }
            System.out.println("-- #" + verIdx);
            System.out.println(StringUtils.join(sql, "\n-- NewLine\n"));
            verIdx++;
        }
    }
}

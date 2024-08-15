
package com.rebuild.core.privileges;

import com.rebuild.TestSupport;
import org.junit.jupiter.api.Test;

/**
 * @author devezhao-mbp zhaofang123@gmail.com
 * @since 2019/10/29
 */
public class ChangeOwningDeptTaskTest extends TestSupport {

    @Test
    public void exec() {
        new ChangeOwningDeptTask(SIMPLE_USER, DepartmentService.ROOT_DEPT).exec();
    }
}
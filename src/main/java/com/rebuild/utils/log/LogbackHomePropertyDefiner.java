
package com.rebuild.utils.log;

import ch.qos.logback.core.PropertyDefinerBase;
import com.rebuild.core.support.RebuildConfiguration;

/**
 * logback dir : ${DataDirectory}/_log/
 *
 * @author devezhao
 * @since 2020/10/20
 */
public class LogbackHomePropertyDefiner extends PropertyDefinerBase {

    @Override
    public String getPropertyValue() {
        return RebuildConfiguration.getFileOfData("_log").getAbsolutePath();
    }
}

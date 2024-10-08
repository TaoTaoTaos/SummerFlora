
package com.rebuild.core.support;

import com.rebuild.utils.CommonsUtils;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class HeavyStopWatcherTest {

    @Test
    void tests() throws InterruptedException {
        System.setProperty("_HeavyStopWatcher", "true");

        HeavyStopWatcher.createWatcher("tests");

        HeavyStopWatcher.start(null);
        TimeUnit.MICROSECONDS.sleep(CommonsUtils.randomInt(100, 1000));
        HeavyStopWatcher.stop();

        HeavyStopWatcher.start("2");
        TimeUnit.MICROSECONDS.sleep(CommonsUtils.randomInt(100, 1000));
        HeavyStopWatcher.stop();

        HeavyStopWatcher.start(null);
        TimeUnit.MICROSECONDS.sleep(CommonsUtils.randomInt(100, 1000));
        HeavyStopWatcher.stop();

        // finally
        HeavyStopWatcher.clean();
    }
}
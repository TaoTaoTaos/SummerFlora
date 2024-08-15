
package com.rebuild.core.support.task;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 节流
 *
 * @author Zixin
 * @since 2022/10/13
 */
@Slf4j
public class Throttled {

    final private long delay;

    private Timer timer;

    public Throttled(long delay) {
        this.delay = delay;
    }

    public void submit(TimerTask command) {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
        timer = new Timer("Throttled-" + System.currentTimeMillis());
        timer.schedule(command, delay);
    }
}

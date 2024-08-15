
package com.rebuild.core;

import com.rebuild.core.support.task.TaskExecutors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * 关闭服务时清理
 *
 * @author devezhao
 * @since 2020/10/21
 */
@Component
@Slf4j
public class BootShutdown implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        log.warn("Rebuild shutting down ...");

        TaskExecutors.shutdown();
    }
}

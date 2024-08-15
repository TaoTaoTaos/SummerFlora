
package com.rebuild.core.service.notification;

import cn.devezhao.persist4j.engine.ID;

/**
 * 消息分发
 *
 * @author devezhao
 * @since 2021/7/20
 */
public interface MessageDistributor {

    /**
     * @param message
     * @param messageId
     * @return
     */
    boolean send(Message message, ID messageId);

    /**
     * 激活?
     * 
     * @return
     */
    boolean isEnable();
}

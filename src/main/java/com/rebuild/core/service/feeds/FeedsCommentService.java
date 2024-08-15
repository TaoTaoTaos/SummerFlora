
package com.rebuild.core.service.feeds;

import cn.devezhao.persist4j.PersistManagerFactory;
import com.rebuild.core.metadata.EntityHelper;
import org.springframework.stereotype.Service;

/**
 * 评论
 *
 * @author ZHAO
 * @since 2019/11/4
 */
@Service
public class FeedsCommentService extends BaseFeedsService {

    protected FeedsCommentService(PersistManagerFactory aPMFactory) {
        super(aPMFactory);
    }

    @Override
    public int getEntityCode() {
        return EntityHelper.FeedsComment;
    }
}

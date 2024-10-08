
package com.rebuild.core.configuration.general;

import cn.devezhao.persist4j.PersistManagerFactory;
import cn.devezhao.persist4j.engine.ID;
import com.rebuild.core.configuration.BaseConfigurationService;
import com.rebuild.core.metadata.EntityHelper;
import org.springframework.stereotype.Service;

/**
 * 高级查询
 *
 * @author devezhao-mbp zhaofang123@gmail.com
 * @since 2019/04/30
 */
@Service
public class AdvFilterService extends BaseConfigurationService {

    protected AdvFilterService(PersistManagerFactory aPMFactory) {
        super(aPMFactory);
    }

    @Override
    public int getEntityCode() {
        return EntityHelper.FilterConfig;
    }

    @Override
    protected void cleanCache(ID cfgid) {
        AdvFilterManager.instance.clean(cfgid);
    }
}

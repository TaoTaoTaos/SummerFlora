
package com.rebuild.core.service.dashboard;

import cn.devezhao.persist4j.PersistManagerFactory;
import cn.devezhao.persist4j.engine.ID;
import com.rebuild.core.configuration.BaseConfigurationService;
import com.rebuild.core.metadata.EntityHelper;
import org.springframework.stereotype.Service;

/**
 * 图表
 *
 * @author devezhao-mbp zhaofang123@gmail.com
 * @since 2019/06/04
 */
@Service
public class ChartConfigService extends BaseConfigurationService {

    protected ChartConfigService(PersistManagerFactory aPMFactory) {
        super(aPMFactory);
    }

    @Override
    public int getEntityCode() {
        return EntityHelper.ChartConfig;
    }

    @Override
    protected void cleanCache(ID cfgid) {
        ChartManager.instance.clean(cfgid);
    }
}

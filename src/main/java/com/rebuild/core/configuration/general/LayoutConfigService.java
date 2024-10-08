
package com.rebuild.core.configuration.general;

import cn.devezhao.persist4j.PersistManagerFactory;
import cn.devezhao.persist4j.engine.ID;
import com.rebuild.core.configuration.BaseConfigurationService;
import com.rebuild.core.metadata.EntityHelper;
import com.rebuild.core.privileges.AdminGuard;
import org.springframework.stereotype.Service;

/**
 * 表单配置
 *
 * @author devezhao-mbp zhaofang123@gmail.com
 * @since 2019/04/30
 */
@Service
public class LayoutConfigService extends BaseConfigurationService implements AdminGuard {

    protected LayoutConfigService(PersistManagerFactory aPMFactory) {
        super(aPMFactory);
    }

    @Override
    public int getEntityCode() {
        return EntityHelper.LayoutConfig;
    }

    @Override
    protected void cleanCache(ID cfgid) {
        BaseLayoutManager.instance.clean(cfgid);
    }
}


package com.rebuild.core.configuration.general;

import cn.devezhao.persist4j.PersistManagerFactory;
import cn.devezhao.persist4j.engine.ID;
import com.rebuild.core.configuration.BaseConfigurationService;
import com.rebuild.core.metadata.EntityHelper;
import com.rebuild.core.privileges.AdminGuard;
import org.springframework.stereotype.Service;

/**
 * @author devezhao
 * @since 2020/10/27
 */
@Service
public class TransformConfigService extends BaseConfigurationService implements AdminGuard {

    protected TransformConfigService(PersistManagerFactory aPMFactory) {
        super(aPMFactory);
    }

    @Override
    public int getEntityCode() {
        return EntityHelper.TransformConfig;
    }

    @Override
    protected void cleanCache(ID cfgid) {
        TransformManager.instance.clean(cfgid);
    }
}

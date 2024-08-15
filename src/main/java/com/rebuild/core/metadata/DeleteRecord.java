
package com.rebuild.core.metadata;

import cn.devezhao.persist4j.engine.ID;
import cn.devezhao.persist4j.engine.StandardRecord;

/**
 * 删除专用
 * 
 * @author devezhao
 * @since 2022/1/10
 */
public class DeleteRecord extends StandardRecord {
    private static final long serialVersionUID = -7098132591224439549L;

    public DeleteRecord(ID primaryid, ID editor) {
        super(MetadataHelper.getEntity(primaryid.getEntityCode()), editor);
        this.setID(getEntity().getPrimaryField().getName(), primaryid);
    }
}

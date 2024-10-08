
package com.rebuild.core.service.general.recyclebin;

import cn.devezhao.persist4j.Entity;
import cn.devezhao.persist4j.Field;
import cn.devezhao.persist4j.Record;
import cn.devezhao.persist4j.engine.StandardRecord;
import cn.devezhao.persist4j.record.JsonRecordCreator;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rebuild.core.metadata.easymeta.DisplayType;
import com.rebuild.core.metadata.easymeta.EasyMetaFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * @author devezhao
 * @since 2019/8/21
 */
@Slf4j
public class RestoreRecordCreator extends JsonRecordCreator {

    public RestoreRecordCreator(Entity entity, JSONObject source) {
        super(entity, source);
    }

    // ignoreNullValueWhenNew always true
    @Override
    public Record create(boolean ignoreNullValueWhenNew) {
        Record record = new StandardRecord(entity, null);

        for (Map.Entry<String, Object> e : source.entrySet()) {
            String fileName = e.getKey();
            if (!entity.containsField(fileName)) {
                log.warn("Cannot found field [ " + entity.getName() + '#' + fileName + " ], will ignore");
                continue;
            }

            Object value = e.getValue();
            if (value == null || StringUtils.isEmpty(value.toString()))
                continue;

            // fix: v3.5.6/v3.6
            DisplayType dt = EasyMetaFactory.getDisplayType(entity.getField(fileName));
            if (dt == DisplayType.N2NREFERENCE || dt == DisplayType.TAG) {
                // 只需保留一个作为标志，因为 NreferenceItem/TagItem 中并未删除
                try {
                    JSONArray valueArray = (JSONArray) value;
                    value = valueArray.get(0);
                } catch (Exception ignored) {
                    continue;
                }
            }

            setFieldValue(entity.getField(fileName), value.toString(), record);
        }
        return record;
    }

    @Override
    public boolean onSetFieldValueWarn(Field field, String value, Record record) {
        return true;
    }

    @Override
    public void verify(Record record) {
        log.warn("Restore record ignore verification : {}", record.getPrimary());
    }
}

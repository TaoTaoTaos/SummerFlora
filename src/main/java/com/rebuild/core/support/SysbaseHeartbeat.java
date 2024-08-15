
package com.rebuild.core.support;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.FileAppender;
import cn.devezhao.commons.CalendarUtils;
import com.alibaba.fastjson.JSONObject;
import com.rebuild.core.Application;
import com.rebuild.core.ServerStatus;
import com.rebuild.core.cache.CommonsCache;
import com.rebuild.core.support.i18n.Language;
import com.rebuild.utils.CommonsUtils;
import com.rebuild.utils.OshiUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * @author devezhao
 * @since 2020/12/7
 */
@Slf4j
public class SysbaseHeartbeat {

    private static final String CKEY_DANGERS = "_DANGERS";

    private static final String AdminMsg = "AdminMsg";
    private static final String UsersMsg = "UsersMsg";

    private static final String DateNotSync = "DateNotSync";

    public static final String DatabaseBackupFail = "DatabaseBackupFail";
    public static final String DataFileBackupFail = "DataFileBackupFail";

    /**
     * Check server
     */
    public void heartbeat() {
        ServerStatus.getLastStatus(true);

        LinkedHashMap<String, String> dangers = getDangersList();

        // #1

        // #3
        final Date networkDate = OshiUtils.getNetworkDate();
        final Date localDate = CalendarUtils.now();
        final long networkDateLeft = (networkDate.getTime() - localDate.getTime()) / 1000;
        if (Math.abs(networkDateLeft) > 15) {
            log.warn("Server date offset : {} vs {}", networkDate, localDate);
            dangers.put(DateNotSync, String.valueOf(networkDateLeft));
        } else {
            dangers.remove(DateNotSync);
        }

        Application.getCommonsCache().putx(CKEY_DANGERS, dangers, CommonsCache.TS_DAY);
    }

    @SuppressWarnings("unchecked")
    static LinkedHashMap<String, String> getDangersList() {
        LinkedHashMap<String, String> dangers = (LinkedHashMap<String, String>) Application.getCommonsCache()
                .getx(CKEY_DANGERS);
        return dangers == null ? new LinkedHashMap<>() : (LinkedHashMap<String, String>) dangers.clone();
    }

    /**
     * @param name
     * @param message
     */
    public static void setItem(String name, String message) {
        LinkedHashMap<String, String> dangers = getDangersList();
        if (message == null)
            dangers.remove(name);
        else
            dangers.put(name, message);

        Application.getCommonsCache().putx(CKEY_DANGERS, dangers, CommonsCache.TS_DAY * 2);
    }

    /**
     * @return
     */
    public static Collection<String> getAdminDanger() {
        LinkedHashMap<String, String> dangers = getDangersList();

        if (dangers.isEmpty())
            return null;

        dangers.remove(UsersMsg);

        if (RebuildConfiguration.getBool(ConfigurationItem.DBBackupsEnable)) {
            String hasDatabaseBackupFail = dangers.get(DatabaseBackupFail);
            if (hasDatabaseBackupFail != null) {
                dangers.put(DatabaseBackupFail,
                        Language.L("数据备份失败")
                                + String.format("<blockquote class=\"code\">%s</blockquote>", hasDatabaseBackupFail));
            }

            String hasDataFileBackupFail = dangers.get(DataFileBackupFail);
            if (hasDataFileBackupFail != null) {
                dangers.put(DataFileBackupFail,
                        Language.L("数据备份失败")
                                + String.format("<blockquote class=\"code\">%s</blockquote>", hasDataFileBackupFail));
            }
        }

        String hasNetworkDateLeft = dangers.get(DateNotSync);
        if (hasNetworkDateLeft != null) {
            dangers.put(DateNotSync,
                    Language.L("服务器时间与网络时间存在偏移，可能导致某些功能异常，建议检查并同步服务器时间"));
        }

        return dangers.values();
    }

    /**
     * @return
     */
    public static String getUsersDanger() {
        LinkedHashMap<String, String> dangers = getDangersList();
        return dangers.get(UsersMsg);
    }

    /**
     * @return
     */
    public static File getLogbackFile() {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger lg = lc.getLogger("ROOT");
        FileAppender<?> fa = (FileAppender<?>) lg.getAppender("FILE");
        return new File(fa.getFile());
    }
}

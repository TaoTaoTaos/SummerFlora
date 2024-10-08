
package com.rebuild.utils;

import com.rebuild.core.Application;
import org.apache.commons.lang.SystemUtils;

/**
 * @author devezhao
 * @see org.springframework.boot.Banner
 * @since 09/17/2020
 */
public class RebuildBanner {

    static final String COMMON_BANNER = "" +
            "\n  Version : " + Application.VER +
            "\n  OS      : " + SystemUtils.OS_NAME + " (" + SystemUtils.OS_ARCH + ")" +
            "\n  JVM     : " + SystemUtils.JAVA_VM_NAME + " (" + SystemUtils.JAVA_VERSION + ")" +
            "\n" +
            "\n  Report an issue :" +
            "\n  https:// /report-issue?title=boot";

    static final String FLAG_LINE = "####################################################################";

    /**
     * @param texts
     * @return
     */
    public static String formatBanner(String... texts) {
        StringBuilder banner = new StringBuilder()
                .append("\n\n").append(FLAG_LINE).append("\n\n");

        for (String t : texts) {
            banner.append("  ").append(t).append("\n");
        }

        banner.append(COMMON_BANNER).append("\n");

        return banner.append("\n").append(FLAG_LINE).append("\n").toString();
    }

    /**
     * @param texts
     * @return
     */
    public static String formatSimple(String... texts) {
        StringBuilder banner = new StringBuilder("\n");
        for (String t : texts) {
            banner.append("  ").append(t).append("\n");
        }
        return banner.toString();
    }
}

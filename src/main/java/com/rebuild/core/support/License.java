package com.rebuild.core.support;

import cn.devezhao.commons.CodecUtils;
import com.alibaba.fastjson.JSONObject;
import com.rebuild.core.Application;
import com.rebuild.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeansException;

import java.util.Locale;

@Slf4j
public final class License {

    private static final String TEMP_SN = "SN000-00000000-000000000";

    private static String USE_SN;
    private static Boolean USE_RBV;

    public static String SN() {
        if (USE_SN != null)
            return USE_SN;

        String SN = RebuildConfiguration.get(ConfigurationItem.SN, true);
        if (SN != null) {
            if (Application.isReady())
                USE_SN = SN;
            return SN;
        }

        if (!Application.isReady())
            return TEMP_SN;

        // 本地生成 SN 逻辑
        SN = String.format("RB%s%s-%s-%s",
                Application.VER.charAt(0),
                Locale.getDefault().getCountry().substring(0, 2),
                "LOCALKEY",
                CodecUtils.randomCode(9)).toUpperCase();
        RebuildConfiguration.setValue(ConfigurationItem.SN.name(), SN);

        USE_SN = SN;
        return SN;
    }

    public static JSONObject queryAuthority() {
        // 返回一个本地生成的权威信息
        return JSONUtils.toJSONObject(
                new String[] { "sn", "authType", "authObject", "authExpires" },
                new String[] { SN(), "商业版", "YourCompany", "永久" });
    }

    public static int getCommercialType() {
        return 1; // 表示商业版类型
    }

    public static boolean isCommercial() {
        return true; // 始终返回 true，表示商业版
    }

    public static boolean isRbvAttached() {
        if (USE_RBV != null)
            return USE_RBV;
        if (!isCommercial()) {
            USE_RBV = false;
            return false;
        }

        try {
            Application.getContext().getBean("@rbv");
            USE_RBV = true;
        } catch (BeansException norbv) {
            USE_RBV = false;
        }
        return USE_RBV;
    }

    public static JSONObject siteApiNoCache(String param) {
        // 示例逻辑：假设我们根据传入的参数生成一个 JSON 对象
        JSONObject result = new JSONObject();
        result.put("param", param);
        result.put("status", "success");
        result.put("timestamp", System.currentTimeMillis());

        log.info("siteApiNoCache called with param: {}", param);
        return result;
    }

    public static JSONObject siteApi(String param) {
        // 示例逻辑：与 siteApiNoCache 类似，但可以在这里添加缓存逻辑
        JSONObject result = new JSONObject();
        result.put("param", param);
        result.put("status", "success");
        result.put("timestamp", System.currentTimeMillis());

        log.info("siteApi called with param: {}", param);
        return result;
    }
}

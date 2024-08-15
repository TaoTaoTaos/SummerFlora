
package com.rebuild.core.service.general.series;

import cn.devezhao.commons.CalendarUtils;

/**
 * 时间系列
 * w, W, SSS
 *
 * @author devezhao
 * @since 12/24/2018
 */
public class TimeVar extends SeriesVar {

    /**
     * @param symbols
     */
    protected TimeVar(String symbols) {
        super(symbols);
    }

    @Override
    public String generate() {
        String s = getSymbols().replace("Y", "y");
        // YYYY-MM-DD HH-II-SS > yyyy-MM-dd HH-mm:ss
        s = s.replace("D", "d");
        s = s.replace("I", "m");
        s = s.replace("S", "s");
        s = s.replace("sss", "SSS");
        return CalendarUtils.format(s, CalendarUtils.now());
    }
}

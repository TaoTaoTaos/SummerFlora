
package com.rebuild.core.service.dashboard.charts;

/**
 * 显示样式
 *
 * @author devezhao
 * @since 12/15/2018
 */
public class FormatStyle {

    private String fontsize;
    private String fontcolor;
    private String formatted;

    public FormatStyle(String fontsize, String fontcolor, String formatted) {
        this.fontsize = fontsize;
        this.fontcolor = fontcolor;
        this.formatted = formatted;
    }

    public String getFontsize() {
        return fontsize;
    }

    public String getFontcolor() {
        return fontcolor;
    }

    public String getFormatted() {
        return formatted;
    }
}

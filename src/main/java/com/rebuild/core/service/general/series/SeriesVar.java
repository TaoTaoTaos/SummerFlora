
package com.rebuild.core.service.general.series;

/**
 * 系列变量
 *
 * @author devezhao
 * @since 12/24/2018
 */
public abstract class SeriesVar {

    private String symbols;

    protected SeriesVar(String symbols) {
        this.symbols = symbols;
    }

    public String getSymbols() {
        return symbols;
    }

    abstract public String generate();
}

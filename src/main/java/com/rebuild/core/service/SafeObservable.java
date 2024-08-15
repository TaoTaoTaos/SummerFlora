
package com.rebuild.core.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Thread-Safe `Observable`
 *
 * @author devezhao
 * @since 2023/12/22
 */
public class SafeObservable {

    final private List<SafeObserver> obs;

    public SafeObservable() {
        obs = new ArrayList<>();
    }

    public void addObserver(SafeObserver o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o)) {
            obs.add(o);
            obs.sort(Comparator.comparingInt(SafeObserver::getOrder));
        }
    }

    public void notifyObservers(Object arg) {
        for (SafeObserver o : obs) {
            o.update(this, arg);
        }
    }

    public int countObservers() {
        return obs.size();
    }
}

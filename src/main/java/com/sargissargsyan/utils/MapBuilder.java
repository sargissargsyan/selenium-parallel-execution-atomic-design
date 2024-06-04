package com.sargissargsyan.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Sargis Sargsyan on 5/23/2024
 * @project selenium-parallel-execution
 */
public class MapBuilder<K, V> {

    private final Map<K, V> map;
    private final boolean acceptNull;

    public MapBuilder(boolean acceptNull) {
        this.acceptNull = acceptNull;
        this.map = new HashMap<>();
    }

    public MapBuilder<K, V> put(K key, V value) {
        map.put(key, value);
        return this;
    }

    public Map<K, V> build() {
        if (!acceptNull) {
            map.values().removeAll(Collections.singleton(null));
            map.keySet().removeAll(Collections.singleton(null));
        }
        return map;
    }
}

package com.sjzxy.fwpt.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public static <K, V> Map<K, V> listToMap(List<K> keys, List<V> values) {
        List list = new ArrayList();
//        List<K> keys, List<V> values
        return keys.stream().collect(Collectors.toMap(key -> key, key -> values.get(keys.indexOf(key))));
    }

}

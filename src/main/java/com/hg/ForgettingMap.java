package com.hg;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ForgettingMap<K, V> {

    private final int maxSize;
    private final Map<K, V> forgettingMap;
    private final Map<K, Integer> forgettingMapAccessCount;

    public ForgettingMap(int maxSize) {
        this.maxSize = maxSize;
        this.forgettingMap = new HashMap<>();
        this.forgettingMapAccessCount = new HashMap<>();
    }

    public synchronized V add(K key, V value) {

        if(forgettingMap.size() >= maxSize) {
            // remove least used item from map
            removeLeastUsedItemFromMap();
        }

        forgettingMapAccessCount.put(key, 0);
        return forgettingMap.put(key, value);
    }

    public synchronized V find(K key) {

        // increment counter when key is retrieved by find method
        if(forgettingMapAccessCount.containsKey(key)) {
            forgettingMapAccessCount.put(key, forgettingMapAccessCount.get(key) + 1);
        }

        return forgettingMap.get(key);
    }

    private void removeLeastUsedItemFromMap() {
        // find out which item has least used count and remove

        K key = Collections.min(forgettingMapAccessCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(key);
        forgettingMapAccessCount.remove(key);
        forgettingMap.remove(key);
    }

}

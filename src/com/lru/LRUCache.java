package com.lru;

import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

/**
 * @description 缓存lru算法（least recently used 最近最少使用）
 * @Date 2022/1/21 10:38
 * @Created by lianhai.deng
 */

public class LRUCache<K,V> implements Cache<K,V> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Boolean put(Object key, Object value) {
        return null;
    }

    @Override
    public Optional get(Object key) {
        return Optional.empty();
    }
}

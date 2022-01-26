package com.lru;

import java.util.Optional;

/**
 * @description 缓存接口类
 * @Date 2022/1/21 10:43
 * @Created by lianhai.deng
 */

public interface Cache<K, V> {
    int size();
    // 新增
    Boolean put(K key, V value);
    // 获取
    Optional<V> get(K key);
}

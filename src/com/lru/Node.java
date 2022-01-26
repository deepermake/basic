package com.lru;

/**
 * @description
 * @Date 2022/1/21 10:55
 * @Created by lianhai.deng
 */

public class Node {
    int key;
    int value;
    // 前置节点
    Node pre;
    // 后置节点
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

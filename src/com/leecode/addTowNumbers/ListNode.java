package com.leecode.addTowNumbers;


import com.lru.Node;

import java.util.List;
import java.util.Objects;

public class ListNode {

    /**
     * 值
     */
    private Integer value;

    /**
     * 指向下一个node
     */
    private ListNode next;

    public ListNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static ListNode initNode(Integer[] arr) {
        if (Objects.isNull(arr) || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode other = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            other.next = node;
            other = other.next;
        }
        return head;
    }

    public static String printListNode(ListNode node) {
        if (node == null) {
            return "";
        }
        String result = "";
        while (node.next != null) {
            result = result + node.value + "-->";
            node = node.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4};
        ListNode listNode = ListNode.initNode(arr);
        System.out.printf(ListNode.printListNode(listNode));
    }

}

package com.leecode.addTowNumbers;


import java.util.Objects;

public class ListNode {

    /**
     * 值
     */
    private Integer val;

    /**
     * 指向下一个node
     */
    private ListNode next;

    public ListNode(Integer val) {
        this.val = val;
    }

    public Integer getval() {
        return val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    public void setval(Integer val) {
        this.val = val;
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
        StringBuilder result = new StringBuilder();
        while (node != null) {
            result.append(node.val);
            if (node.next != null) {
                result.append("->");
            }
            node = node.next;
        }
        return result.toString();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        // 尝试用遍历解决
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode result = null;
        ListNode other = result;
        int add = 0;
        Integer left = 0;
        while (node1 != null || node2 != null) {
            if (node1 != null && node2 == null) {
                add = node1.val + left;
                node1 = node1.next;
            }
            if (node1 == null && node2 != null) {
                add = node2.val + left;
                node2 = node2.next;
            }
            if (node1 != null && node2 != null) {
                add = node1.val + node2.val + left;
                node1 = node1.next;
                node2 = node2.next;
            }
            left = add / 10;
            add = add % 10;
            if (result == null) {
                result = new ListNode(add);
                other = result;
            } else {
                ListNode node = new ListNode(add);
                other.next = node;
                other = other.next;
            }
        }
        if (left == 0) {
            return result;
        }
        other.next = new ListNode(left);
        return result;

    }

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{2, 4, 3};
        ListNode listNode1 = ListNode.initNode(arr1);
        Integer[] arr2 = new Integer[]{5, 6, 4};
        ListNode listNode2 = ListNode.initNode(arr2);
        ListNode result = ListNode.addTwoNumbers(listNode1, listNode2);
        System.out.println(ListNode.printListNode(listNode1));
        System.out.println(ListNode.printListNode(listNode2));
        System.out.println(ListNode.printListNode(result));


    }

}

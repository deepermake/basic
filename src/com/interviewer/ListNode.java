package com.interviewer;

/**
 * 面试题 02.05 链表求和
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public static ListNode arrayToListNode(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static String printListNode(ListNode head) {
        String result = "";
        while (head != null) {
            result = result.concat(String.valueOf(head.val));
            head = head.next;
            if (head != null) {
                result = result.concat("-->");
            }
        }
        return result;
    }
}

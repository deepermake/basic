package com.interviewer;

/**
 * 面试题 02.04 分割链表
 */

public class Partition {
    public static void main(String[] args) {
        ListNode node = partition(ListNode.arrayToListNode(new int[]{1, 4, 3, 2, 5, 2}), 3);
        System.out.println(ListNode.printListNode(node));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode node = head;
        ListNode result = new ListNode();
        ListNode re = result;
        while (node != null) {
            if (node.val < x) {
                re.next = new ListNode(node.val);
                re = re.next;
            }
            node = node.next;
        }

        while (head != null) {
            if (head.val >= x) {
                re.next = new ListNode(head.val);
                re = re.next;
            }
            head = head.next;
        }
        return result.next;
    }
}

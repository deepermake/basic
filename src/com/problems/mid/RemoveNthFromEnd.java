package com.problems.mid;

import com.interviewer.ListNode;

/**
 * 19 - 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = ListNode.arrayToListNode(new int[]{1, 2, 3, 4, 5});
        ListNode res = removeNthFromEnd(head, 5);
        System.out.println(ListNode.printListNode(res));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode node = head;
        ListNode ln = new ListNode();
        ListNode result = ln;

        int i = 0;
        while (temp != null) {
            temp = temp.next;
            i++;
            if (i > n) {
                ln.next = new ListNode(node.val);
                ln = ln.next;
                node = node.next;
            }
        }
        if (node != null && node.next != null) {
            ln.next = node.next;
        }
        return result.next;
    }
}

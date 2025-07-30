package com.problems.mid;

import com.interviewer.ListNode;

/**
 * 61 旋转链表
 */

public class RotateRight {

    public static void main(String[] args) {
        ListNode node = ListNode.arrayToListNode(new int[]{1, 2, 3, 4, 5});
        ListNode res = rotateRight(node, 4);
        System.out.println(ListNode.printListNode(res));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        ListNode num = head;
        int m = 0;
        while (num != null) {
            num = num.next;
            m++;
        }
        k = k % m;
        ListNode ln = new ListNode();
        ListNode re = ln;
        int i = 0;
        while (i < k) {
            if (node.next != null) {
                ln.next = new ListNode(node.val);
                ln = ln.next;
                node = node.next;
                continue;
            }
            i++;
            ListNode temp = re.next;
            re = node;
            re.next = temp;
            ln = new ListNode();
            re = ln;
        }
        return node;
    }
}

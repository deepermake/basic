package com.interviewer;

/**
 * 面试题 02.02 返回倒数第k个节点
 */
public class KthToLast {

    public static void main(String[] args) {
        System.out.println(kthToLast(ListNode.arrayToListNode(new int[]{1, 2, 3, 4, 5}),1));
        System.out.println(kthToLast(ListNode.arrayToListNode(new int[]{2,3}),1));

    }

    public static int kthToLast(ListNode head, int k) {
        ListNode node = head;
        ListNode temp = head;
        int i = 0;
        while (temp != null) {
            temp = temp.next;
            i++;
            if (i > k) {
                node = node.next;
            }
        }
        return node.val;
    }
}



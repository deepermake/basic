package com.interviewer;

/**
 * 面试题 02.05 链表求和
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = ListNode.arrayToListNode(new int[]{1,8});
        ListNode node2 = ListNode.arrayToListNode(new int[]{0});
        ListNode result = addTwoNumbers(node1, node2);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode result = new ListNode();
        ListNode headResult = result;
        int temp = 0;
        while (head1 != null || head2 != null) {
            int value = 0;
            if (head1 != null && head2 != null) {
                value = head1.val + head2.val + temp;
                head1 = head1.next;
                head2 = head2.next;
            }else if (head1 == null && head2 != null) {
                value = head2.val + temp;
                head2 = head2.next;
            }else if (head1 != null && head2 == null) {
                value = head1.val + temp;
                head1 = head1.next;
            }
            temp = value / 10;
            headResult.next = new ListNode(value % 10);
            headResult = headResult.next;
        }

        if (temp != 0) {
            headResult.next = new ListNode(temp);
        }

        return result.next;
    }
}

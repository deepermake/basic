package com.problems.mid;

import com.interviewer.ListNode;

import java.util.Stack;

/**
 * 445 - 两数相加II
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = ListNode.arrayToListNode(new int[]{7, 2, 4, 3});
        ListNode l2 = ListNode.arrayToListNode(new int[]{8, 5, 6, 4});
        ListNode re = addTwoNumbers(l1, l2);
        System.out.println(ListNode.printListNode(re));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        ListNode ln1 = l1;
        while (ln1 != null) {
            s1.push(ln1.val);
            ln1 = ln1.next;
        }
        ListNode ln2 = l2;
        while (ln2 != null) {
            s2.push(ln2.val);
            ln2 = ln2.next;
        }

        Stack<Integer> sre = new Stack<>();
        int temp = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int re = temp;
            if (!s1.isEmpty()) {
                re = re + s1.pop();
            }
            if (!s2.isEmpty()) {
                re = re + s2.pop();
            }
            temp = re / 10;
            re = re % 10;
            sre.push(re);
        }

        if (temp != 0) {
            sre.push(temp);
        }

        ListNode reNode = new ListNode(sre.pop());
        ListNode rn = reNode;
        while (!sre.isEmpty()) {
            rn.next = new ListNode(sre.pop());
            rn = rn.next;
        }

        return reNode;

    }
}

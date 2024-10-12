package com.interviewer;

import java.util.Stack;

/**
 * 面试题 02.06 回文链表
 */
public class IsPalindrome {

    public static void main(String[] args) {
//        System.out.println(isPalindrome(ListNode.arrayToListNode(new int[]{1, 2, 2, 1})));
//        System.out.println(isPalindrome(ListNode.arrayToListNode(new int[]{1, 2})));
        System.out.println(isPalindrome(ListNode.arrayToListNode(new int[]{1, 0, 0})));
    }

    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }

        while (head != null){
            if (stack.pop() != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}

package com.interviewer;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01 移除重复节点
 */
public class RemoveDuplicateNodes {

    public static void main(String[] args) {
        System.out.println(ListNode.printListNode(removeDuplicateNodes(ListNode.arrayToListNode(new int[]{1, 2, 3, 3, 2, 1}))));
    }


    /**
     * 哈希解法
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode result = new ListNode();
        ListNode node = result;
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head.val)) {
                set.add(head.val);
                node.next = new ListNode(head.val);
                node = node.next;

            }
            head = head.next;
        }
        return result.next;
    }


}

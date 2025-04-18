package com.leecode.mergetwolists;

/**
 *
 * @description
 * @author 邓联海
 * @date 2021/5/28 15:23
 */
public class MergeTwoList {

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(2);
        System.out.println(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode l3 = new ListNode();
        ListNode temp = l3;
        while (l1 != null && l2 != null){
            ListNode p = l3.next;
            if (l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next =  l1 == null ? l2 : l1;
        return l3.next;
    }
}

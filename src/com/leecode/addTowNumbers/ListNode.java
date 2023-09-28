package com.leecode.addTowNumbers;


import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class ListNode {

    /**
     * 值
     */
    private Integer val;

    /**
     * 指向下一个node
     */
    private ListNode next;

    public ListNode(Integer val) {
        this.val = val;
    }

    public Integer getval() {
        return val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    public void setval(Integer val) {
        this.val = val;
    }

    public static ListNode initNode(Integer[] arr) {
        if (Objects.isNull(arr) || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode other = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            other.next = node;
            other = other.next;
        }
        return head;
    }

    public static String printListNode(ListNode node) {
        if (node == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        while (node != null) {
            result.append(node.val);
            if (node.next != null) {
                result.append("->");
            }
            node = node.next;
        }
        return result.toString();
    }

    /**
     * 两数相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        // 尝试用遍历解决
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode result = null;
        ListNode other = result;
        int add = 0;
        Integer left = 0;
        while (node1 != null || node2 != null) {
            if (node1 != null && node2 == null) {
                add = node1.val + left;
                node1 = node1.next;
            }
            if (node1 == null && node2 != null) {
                add = node2.val + left;
                node2 = node2.next;
            }
            if (node1 != null && node2 != null) {
                add = node1.val + node2.val + left;
                node1 = node1.next;
                node2 = node2.next;
            }
            left = add / 10;
            add = add % 10;
            if (result == null) {
                result = new ListNode(add);
                other = result;
            } else {
                ListNode node = new ListNode(add);
                other.next = node;
                other = other.next;
            }
        }
        if (left == 0) {
            return result;
        }
        other.next = new ListNode(left);
        return result;

    }


    /**
     * 链表排序
     *
     * @param head
     * @return
     */
    public static ListNode sortListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 以slow为分割节点一分为二，左边为head 右边为temp
        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortListNode(head);
        ListNode right = sortListNode(temp);

        ListNode dum = new ListNode(0);
        ListNode res = dum;
        while (left != null && right != null) {
            if (left.val > right.val) {
                dum.next = right;
                right = right.next;
            } else {
                dum.next = left;
                left = left.next;
            }
            dum = dum.next;
        }
        dum.next = left != null ? left : right;
        return res.next;
    }


    /**
     * 去除重复链表
     *
     * @param head
     * @return
     */
    public static ListNode delRepeatNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp = head, node = head.next;
        while (node != null) {
            if (Objects.equals(tmp.val, node.val)) {
                node = node.next;
                tmp.next = node;
            } else {
                tmp = tmp.next;
                node = node.next;
            }
        }
        return head;
    }

    /**
     * 删除元素
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode tmp = head, node = head.next;
        while (node != null) {
            if (tmp.next.val == val) {
                tmp.next = node.next;
            } else {
                tmp = tmp.next;
            }
            node = node.next;
        }
        return head;
    }

    /**
     * 二进制链表转整数
     *
     * @param head
     * @return
     */
    public static int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return (int) Math.pow(2, 0) * head.val;
        }

        int index = 0;
        ListNode temp = head;
        while (temp.next != null) {
            index++;
            temp = temp.next;
        }

        double result = 0;
        while (head != null) {
            result = result + Math.pow(2, index) * head.val;
            head = head.next;
            index--;
        }

        return (int) result;
    }

    /**
     * 回文链表
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        while (!stack.isEmpty()) {
            Integer val = stack.pop();
            if (!Objects.equals(val, head.val)) {
                return false;
            }
            head = head.next;
        }

        return true;
    }


    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{2, 4, 3, 1, 4, 6};
        ListNode listNode1 = ListNode.initNode(arr1);
        Integer[] arr2 = new Integer[]{5, 6, 4};
        ListNode listNode2 = ListNode.initNode(arr2);
        Integer[] repeatNode = new Integer[]{1, 1, 2, 2, 3, 3, 4, 4};
        ListNode repeatListNode = ListNode.initNode(repeatNode);
        // System.out.println(ListNode.printListNode(delRepeatNode(repeatListNode)));

//        System.out.println(ListNode.printListNode(sortListNode(listNode1)));
//
//        ListNode result = ListNode.addTwoNumbers(listNode1, listNode2);
//        System.out.println(ListNode.printListNode(listNode1));
//        System.out.println(ListNode.printListNode(listNode2));
//        System.out.println(ListNode.printListNode(result));

        // 删除元素
//        ListNode removeNodes = ListNode.initNode(new Integer[]{1, 1, 2, 2, 3, 3, 4, 4});
//        System.out.println(ListNode.printListNode(removeElements(removeNodes, 1)));

//        ListNode getDecimalNode = ListNode.initNode(new Integer[]{1});
//        System.out.println(getDecimalValue(getDecimalNode));

        ListNode palindromeNode = ListNode.initNode(new Integer[]{1, 2, 2, 1});
        System.out.println(isPalindrome(palindromeNode));


    }

}

package com.problems.mid;

import java.util.Stack;

/**
 * 503 - 下一个更大元素 II
 */
public class NextGreaterElements {

    public static void main(String[] args) {
        // nextGreaterElements(new int[]{5, 4, 3, 2, 1});
        nextGreaterElements(new int[]{1, 2, 1});
        //                            1  2  3  4  5
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        boolean[] visited = new boolean[nums.length];
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < nums.length) {
            if (stack.isEmpty()) {
                stack.push(i++);
                continue;
            }

            if (stack.peek() == i) {
                res[stack.pop()] = -1;
                break;
            }

            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                visited[stack.peek()] = true;
                res[stack.pop()] = nums[i];
            }

            if (!visited[i] && !stack.contains(i)) {
                stack.push(i);
            }

            i++;
            if (i == nums.length) {
                i = 0;
            }

        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }

        return res;

    }
}

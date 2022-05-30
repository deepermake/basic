package com.problems.easy.array.leetcode.editor.cn;

import com.tree.TreeNode;

/**
 * Description: 1022 从根到叶的二进制数之和
 * Link:
 * Author:      lianhai.deng
 * Date:        2022-05-30 15:33:57
 */
public class SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        //  0  1/0  2/0  3/1  4/1  5/3  6/3
        // {1, 0,   1,   0,   1,   0,   1}
        Integer[] arr = new Integer[]{1, 0};

        TreeNode treeNode = TreeNode.convert(arr);

        Solution solution = new SumOfRootToLeafBinaryNumbers().new Solution();
        System.out.println(solution.sumRootToLeaf(treeNode));
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int sumRootToLeaf(TreeNode root) {
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


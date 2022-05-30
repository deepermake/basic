package com.problems.easy.array.leetcode.editor.cn;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 1022 从根到叶的二进制数之和
 * Link:        https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/solution/cong-gen-dao-xie-de-er-jin-zhi-shu-zhi-h-eqss/
 * Author:      lianhai.deng
 * Date:        2022-05-30 15:33:57
 */
public class SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        //  0  1/0  2/0  3/1  4/1  5/3  6/3
        // {1, 0,   1,   0,   1,   0,   1}
        Integer[] arr = new Integer[]{1, 0, 1, 0, 1, 0, 1};

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
            List<List<Integer>> res = new ArrayList<>();
            getEveryLeafSum(root, new ArrayList<>(), res);
            Integer sum = 0;
            for (List list : res) {
                for (int i = 0; i < list.size(); i++) {
                    sum += Math.multiplyExact((int) Math.pow(2, list.size() - i - 1), (Integer) list.get(i));
                }
            }
            return sum;
        }

        public void getEveryLeafSum(TreeNode root, List<Integer> list, List<List<Integer>> res) {
            if (root != null) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(root.val);
                if (root.right == null && root.left == null){
                    res.add(temp);
                }
                if (root.right != null) {
                    getEveryLeafSum(root.right, temp, res);
                }
                if (root.left != null) {
                    getEveryLeafSum(root.left, temp, res);
                    return;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


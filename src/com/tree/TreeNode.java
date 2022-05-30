package com.tree;

import java.util.List;

/**
 * @author lianhai.deng
 * @description 数据结构-树
 * @createTime 2022/4/21 17:44
 */
public class TreeNode {
    /**
     * 节点值
     */
    int value;
    /**
     * 左节点
     */
    TreeNode left;
    /**
     * 右节点
     */
    TreeNode right;

    /**
     * 根节点
     */
    private TreeNode root;

    TreeNode() {
    }

    TreeNode(int value) {
        this.value = value;
    }

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * 前序遍历初始化一棵树
     *
     * @param treeValues
     */
    void initTree(List<Integer> treeValues) {

    }

    public static TreeNode convert(Integer[] nums) {
        int floor = 0, count = 0;

        TreeNode[] treeNodes = new TreeNode[nums.length];
        while (nums != null && count < nums.length) {
            int start = (int) Math.pow(2, floor) - 1;
            int end = (int) Math.pow(2, floor + 1) - 1;
            if (end > nums.length) {
                end = nums.length;
            }

            for (int i = start; i < end; i++) {
                if (nums[i] != null) {
                    treeNodes[i] = new TreeNode(nums[i]);
                } else {
                    treeNodes[i] = null;
                }

                if (i > 0) {
                    int parent = (i - 1) / 2;
                    if (parent >= 0) {
                        TreeNode pNode = treeNodes[parent];
                        if (pNode != null) {
                            if (i % 2 == 1) {
                                pNode.left = treeNodes[i];
                            } else {
                                pNode.right = treeNodes[i];
                            }
                        }
                    }
                }
                count++;
            }
            floor++;
        }
        return treeNodes[0];
    }
}

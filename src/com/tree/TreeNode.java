package com.tree;

import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.Objects;

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
}

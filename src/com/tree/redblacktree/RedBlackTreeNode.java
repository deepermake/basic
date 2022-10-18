package com.tree.redblacktree;

/**
 * Description: 红黑树节点
 * Link:
 * Author:   lianhai.deng
 * Date:     2022/9/5 17:08
 */
public class RedBlackTreeNode {
    /**
     * 节点值
     */
    public int val;

    /**
     * 左节点
     */
    public RedBlackTreeNode left;

    /**
     * 右节点
     */
    public RedBlackTreeNode right;

    /**
     * 颜色， true:红色，false:黑色
     */
    public boolean color;

    /**
     * 父节点
     */
    public RedBlackTreeNode parent;

    public RedBlackTreeNode() {

    }
}

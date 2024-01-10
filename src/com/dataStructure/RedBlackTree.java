//package com.dataStructure;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//public class RedBlackTree<K extends Comparable<K>, V> {
//    // true 表示红色
//    private static final boolean RED = true;
//    // false 表示黑色
//    private static final boolean BLACK = false;
//    // 根节点
//    private TreeNode <K,V> root;
//    // 树的大小
//    private int size;
//
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    @Builder
//    public static class TreeNode <K extends Comparable<K>,V> {
//        // 父节点
//        private TreeNode<K,V> parent;
//        // 左节点
//        private TreeNode<K,V> left;
//        // 右节点
//        private TreeNode<K,V> right;
//        // 颜色
//        private boolean color;
//        // 键
//        private K key;
//        // 值
//        private V value;
//    }
//    /**
//     * 设置父节点
//     */
//    private void setParent(TreeNode<K,V> node,TreeNode<K,V> parentNode) {
//        if (node != null) {
//            node.setParent(parentNode);
//        }
//    }
//
//    /**
//     * 获取叔节点
//     */
//    private TreeNode<K,V> getUncle(TreeNode<K,V> node) {
//        // 获取父节点
//        TreeNode<K, V> parent = node.getParent();
//        // 获取爷爷节点
//        TreeNode<K, V> ancestor = parent.getParent();
//        if (ancestor == null) {
//            // 如果没有爷爷节点则说明父节点为根节点，无叔节点
//            return null;
//        }
//        if (parent == ancestor.getLeft()) {
//            // 说明爷爷节点的左节点是父节点，则爷爷节点的右节点为叔节点
//            return ancestor.getRight();
//        } else {
//            // 说明爷爷节点的右节点是父节点，则爷爷节点的左节点为叔节点
//            return ancestor.getLeft();
//        }
//    }
//
//    /**
//     * 获取兄弟节点
//     */
//    private TreeNode<K,V> getBrother(TreeNode<K,V> node) {
//        // 获取父节点
//        TreeNode<K, V> parent = node.getParent();
//        if (parent == null) {
//            // 如果没有父节点，则说明该节点为根节点，无兄弟节点
//            return null;
//        }
//        return node == parent.getLeft() ? parent.getRight() : parent.getLeft();
//    }
//
//    /**
//     * 找到节点 node 的父节点
//     */
//    private TreeNode<K,V> findParentNode(TreeNode<K,V> node) {
//        TreeNode<K, V> dataRoot = root;
//        TreeNode<K, V> child = dataRoot;
//        while (child != null) {
//            int cr = child.getKey().compareTo(node.getKey());
//            if (cr == 0) {
//                return child;
//            } else if (cr > 0) {
//                dataRoot = child;
//                child = child.getLeft();
//            } else {
//                dataRoot = child;
//                child = child.getRight();
//            }
//        }
//        return dataRoot;
//    }
//
//    /**
//     * 根据 key 查询某个节点
//     */
//    private TreeNode<K,V> findTreeNode(K key) {
//        // 从根节点开始
//        TreeNode<K,V> temp = root;
//        // 节点不为 null 则进行循环查找
//        while (temp != null) {
//            int cr = temp.getKey().compareTo(key);
//            if (cr == 0) {
//                return temp;
//            } else if (cr > 0) {
//                // 往左边找
//                temp = temp.left;
//            } else {
//                // 往右边找
//                temp = temp.right;
//            }
//        }
//        return null;
//    }
//
//    /**
//     * 获取前驱节点：比当前节点小的最大值
//     */
//    private TreeNode<K,V> provNode(TreeNode<K,V> node) {
//        TreeNode<K, V> temp = node.getLeft();
//        if (temp == null) {
//            // 如果当前节点没有左子节点，则它的前驱节点为它的父节点
//            return node.getParent();
//        }
//        while (temp.right != null) {
//            temp = temp.right;
//        }
//        return temp;
//    }
//
//    /**
//     * 获取后继节点：比当前节点大的最小值
//     */
//    private TreeNode<K,V> successNode(TreeNode<K,V> node) {
//        TreeNode<K, V> temp = node.getRight();
//        while (temp.left != null) {
//            temp = temp.left;
//        }
//        return temp;
//    }
//
//
//
//}

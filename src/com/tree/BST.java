package com.tree;

/**
 * @description binary search tree（二分查找树） 特点：每个节点都比自己左子树上的节点大，比右子树的节点小
 * @Date 2022/1/18 10:49
 * @Created by lianhai.deng
 */

public class BST {

    static class TreeNode {
        // 节点值
        public int value;
        // 左子树节点
        public TreeNode left;
        // 右子树节点
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    // 根节点
    private TreeNode root;

    // 插入节点
    public void insert(int key) {
        if (root == null) {
            root = new TreeNode(key);
            return;
        }
        TreeNode current = root;
        TreeNode parent = null;
        // while遍历整棵树，找到插入的节点
        while (true) {
            parent = current;
            // 如果key小于父节点值，则在左子节点插入
            if (key < parent.value) {
                current = parent.left;
                if (current == null) {
                    parent.left = new TreeNode(key);
                    return;
                }
            // 如果key大于父节点值，则在右节点插入
            } else if (key > parent.value) {
                current = parent.right;
                if (current == null) {
                    parent.right = new TreeNode(key);
                    return;
                }
            } else {
                return;
            }
        }
    }

    // 获取树节点
    public TreeNode get(int key) {
        TreeNode current = root;
        // 通过while遍历，遍历条件：当前节点不为空，且当前节点的值不为需要查找的key
        while (current != null && current.value != key) {
            if (key < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }

    // 删除节点
    public boolean delete(int key) {
        TreeNode parent = root;
        TreeNode current = root;
        boolean isLeftChild = false;
        while (current != null && current.value != key) {
            parent = current;
            if (current.value > key) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
        }
        if (current == null) {
            return false;
        }

        // 节点没有子节点
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        // 节点只有一个子节点
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        // 节点有两个子节点
        } else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode successor = null;
        TreeNode successorParent = null;
        TreeNode current = node.right;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != node.right) {
            successorParent.left = successor.right;
            successor.right = node.right;
        }
        return successor;
    }

    public static void main(String[] args) {
        int[] arr = {4,6,8,9,1,23,7};
        BST bst = new BST();
        for (int i : arr){
            bst.insert(i);
        }
    }


}

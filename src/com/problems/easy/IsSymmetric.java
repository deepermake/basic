package com.problems.easy;

import com.tree.TreeNode;

import java.util.Objects;

/**
 * 101 - 对称二叉树
 */
public class IsSymmetric {

    public static void main(String[] args) {
        TreeNode node = TreeNode.convert(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        TreeNode node1 = TreeNode.convert(new Integer[]{1,2,2,null,3,null,3});
        System.out.println(isSymmetric(node));
        System.out.println(isSymmetric(node1));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        return bfs(root.right, root.left);
    }


    public static boolean bfs(TreeNode right, TreeNode left) {
        if (Objects.isNull(right) && Objects.isNull(left)) {
            return true;
        }

        if (Objects.isNull(right) || Objects.isNull(left)) {
            return false;
        }

        if (!Objects.equals(right.val, left.val)) {
            return false;
        }
        return bfs(right.right, left.left) && bfs(right.left, left.right);
    }


}

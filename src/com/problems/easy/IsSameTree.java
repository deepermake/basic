package com.problems.easy;

import com.tree.TreeNode;

import java.util.Objects;

/**
 * 100 - 相同的树
 */
public class IsSameTree {
    public static void main(String[] args) {
//        TreeNode p = TreeNode.convert(new Integer[]{1, 2, 3});
//        TreeNode q = TreeNode.convert(new Integer[]{1, 2, 3});

//        TreeNode p = TreeNode.convert(new Integer[]{1, 2});
//        TreeNode q = TreeNode.convert(new Integer[]{1, null, 2});

        TreeNode p = TreeNode.convert(new Integer[]{1, 2, 1});
        TreeNode q = TreeNode.convert(new Integer[]{1, 1, 2});


        System.out.println(isSameTree(p, q));
    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        }

        if (Objects.isNull(p) || Objects.isNull(q)) {
            return false;
        }

        if (!Objects.equals(p.val, q.val)) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

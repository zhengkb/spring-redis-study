package com.zkb.springredisstudy.algorithm.tree;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        boolean sameTree1 = isSameTree(p.left, q.left);
        boolean sameTree2 = isSameTree(p.right, q.right);
        return sameTree1 && sameTree2;
    }
}



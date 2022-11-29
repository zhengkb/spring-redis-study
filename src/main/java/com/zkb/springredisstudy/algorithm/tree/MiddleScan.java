package com.zkb.springredisstudy.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class MiddleScan {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node1, null);
        TreeNode node3 = new TreeNode(1, null, node2);
        List<Integer> list = inorderTraversal(node3);
        list.forEach(System.out::println);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

}




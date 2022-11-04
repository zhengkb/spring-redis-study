package com.zkb.springredisstudy.base.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.tree.TreeNode;
import java.util.List;

public class TreeCreate {

    public static void main(String[] args) {
        Treenode t1 = new Treenode(1, null, null);
        Treenode t2 = new Treenode(2, null, null);
        Treenode t3 = new Treenode(3, null, null);
        Treenode t9 = new Treenode(9, null, null);
        Treenode t7 = new Treenode(7, t3, t1);
        Treenode t6 = new Treenode(6, t2, t9);
        Treenode t8 = new Treenode(8, t7, t6);
        preScan(t8);
    }

    public static void preScan(Treenode treenode) {
        if (treenode == null) {
            return;
        }
        System.out.print(treenode.value + ",");
        preScan(treenode.leftTreeNode);
        preScan(treenode.rightNode);
    }
}

@Data
@AllArgsConstructor
class Treenode {
    public int value;

    public Treenode leftTreeNode;

    public Treenode rightNode;
}

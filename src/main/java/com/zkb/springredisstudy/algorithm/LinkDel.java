package com.zkb.springredisstudy.algorithm;

import org.apache.el.lang.ELArithmetic;

public class LinkDel {

    private static Node last;

    private static Node first;

    private static int size;

    public static void main(String[] args) {
        addFirst(1);
        addLast(2);
        addFirst(3);
        System.out.println(node(1));
    }

    public static void addLast(Integer value) {
        Node newNode = new Node(last, value, null);
        final Node l = last;

        last = newNode;

        //如果尾节点为空，意味着所有节点为空，那么新创建的这个节点就是头结点
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public static void addFirst(Integer value) {
        Node newNode = new Node(null, value, first);
        final Node f = first;
        first = newNode;

        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;

    }

    public static Integer node(int index) {
        if (index <= (size >> 1)) {
            Node f = first;
            for (int i = 0; i < index; i++) {
                f = f.next;
            }
            return f.value;
        } else {
            Node l = last;
            for (int i = size - 1; i > index; i--) {
                l = last.prev;
            }
            return l.value;
        }
    }
}

class Node {
    public Node prev;

    public Integer value;

    public Node next;

    public Node(Node prev, Integer value, Node next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }
}


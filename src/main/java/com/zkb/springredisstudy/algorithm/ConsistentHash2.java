package com.zkb.springredisstudy.algorithm;

import java.util.*;

public class ConsistentHash2<T> {

    private final int virtualNum;//虚拟节点基数

    private final SortedMap<Integer, T> circle = new TreeMap<>();

    public ConsistentHash2(int virtualNum, Collection<T> nodes) {
        this.virtualNum = virtualNum;
        for (T node : nodes) {
            add(node);
        }
    }

    public void add(T node) {
        for (int i = 0; i < virtualNum; i++) {
            String str = node.toString() + i;
            int hashCode = str.hashCode();
            System.out.println("hashcode:" + hashCode);
            circle.put(hashCode, node);
        }
    }

    public void remove(T node) {
        for (int i = 0; i < virtualNum; i++) {
            String str = node.toString() + i;
            int hashCode = str.hashCode();
            circle.remove(hashCode);
        }
    }

    public T get(Object key) {
        if (circle.isEmpty()) {
            return null;
        }

        int hashCode = key.hashCode();
        System.out.println("hashcode:" + hashCode);
        if (!circle.containsKey(hashCode)) {
            SortedMap<Integer, T> tailMap = circle.tailMap(hashCode);
            hashCode = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }

        T node = circle.get(hashCode);
        return node;
    }

    public int getSize() {
        return circle.size();
    }

    public void testBalance() {
        Set<Integer> keySet = circle.keySet();

        TreeSet<Integer> treeSet = new TreeSet<>(keySet);
        for (Integer hashCode : treeSet) {
            System.out.println(hashCode);
        }

        Iterator<Integer> it1 = treeSet.iterator();
        Iterator<Integer> it2 = treeSet.iterator();

        if (it1.hasNext()) {
            it1.next();
        }

        while (it1.hasNext() && it2.hasNext()) {
            System.out.println(it1.next() - it2.next());
        }
    }

    public static void main(String[] args) {
        Set<String> nodes = new HashSet<String>();
        nodes.add("A");
        nodes.add("B");
        nodes.add("C");

        ConsistentHash2<String> consistentHash = new ConsistentHash2<String>(2, nodes);
        consistentHash.add("D");

        System.out.println("hash circle size: " + consistentHash.getSize());
        System.out.println("location of each node are follows: ");
        consistentHash.testBalance();

        String node =consistentHash.get("apple");
        System.out.println("node----------->:"+node);
        System.out.println("node----------->"+consistentHash.get("BM"));
    }
}

package com.zkb.springredisstudy.algorithm;

import java.util.*;

public class ConsistentHash<T> {

    private final int numberOfReplicas; //节点复制因子，实际节点个数*复制因子=虚拟节点个数

    private final SortedMap<Integer, T> circle = new TreeMap<Integer, T>();//存储虚拟节点的hash值到真实节点的映射

    public ConsistentHash(int numberOfReplicas, Collection<T> nodes) {
        this.numberOfReplicas = numberOfReplicas;
        for (T node : nodes) {
            add(node);
        }
    }

    public void add(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            String nodeStr = node.toString() + i;
            int hashCode = nodeStr.hashCode();
            System.out.println("hashCode:" + hashCode);
            circle.put(hashCode, node);
        }
    }

    public void remove(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove((node.toString() + i).hashCode());
        }
    }

    public T get(Object key) {
        if (circle.isEmpty())
            return null;
        int hash = key.hashCode();
        System.out.println("hashCode------>" + hash);
        if (!circle.containsKey(hash)) {
            //数据映射在虚拟机所在环之间，按顺时针寻找机器，如果没有找到那么就去第一个节点所在的机器
            SortedMap<Integer, T> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    public long getSize() {
        return circle.size();
    }

    public void testBalance() {
        Set<Integer> sets = circle.keySet();
        TreeSet<Integer> sortedSets = new TreeSet<>(sets);
        for (Integer sortedSet : sortedSets) {
            System.out.println(sortedSet);
        }

        System.out.println("-----each location's distance are follows:-----");
        Iterator<Integer> it = sortedSets.iterator();
        Iterator<Integer> it2 = sortedSets.iterator();

        if (it2.hasNext()) {
            it2.next();
        }

        while (it.hasNext() && it2.hasNext()) {
            System.out.println(it.next() - it2.next());
        }
    }

    public static void main(String[] args) {
        Set<String> nodes = new HashSet<String>();
        nodes.add("A");
        nodes.add("B");
        nodes.add("C");

        ConsistentHash<String> consistentHash = new ConsistentHash<String>(2, nodes);
        consistentHash.add("D");

        System.out.println("hash circle size: " + consistentHash.getSize());
        System.out.println("location of each node are follows: ");
        consistentHash.testBalance();

        String node =consistentHash.get("apple");
        System.out.println("node----------->:"+node);
        System.out.println("node----------->"+consistentHash.get("BM"));
    }


}

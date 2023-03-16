package com.zkb.springredisstudy.algorithm.distributeserver;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;

import static com.zkb.springredisstudy.algorithm.distributeserver.Servers.SERVERS;

public class ConsistentHash {


    private static TreeMap<Integer, String> virtualNodes = new TreeMap<>();

    private static final int VIRTUAL_NODES = 160;

    static {
        for (String server : SERVERS) {
            virtualNodes.put(getHashCode(server), server);

            for (int i = 0; i < VIRTUAL_NODES; i++) {
                int hash = getHashCode(server + i);
                virtualNodes.put(hash, server);
            }
        }
    }

    public static String getServer(String IP) {
        int hashCode = getHashCode(IP);
        SortedMap<Integer, String> sortedMap = virtualNodes.tailMap(hashCode);
        Integer treeNodeKey = sortedMap.firstKey();
        if (sortedMap == null) {
            treeNodeKey = virtualNodes.firstKey();
        }
        return virtualNodes.get(treeNodeKey);
    }

    public static int getHashCode(String Ip) {
        final int p = 1904390101;
        int hash = (int) 1901102097L;
        for (int i = 0; i < Ip.length(); i++) {
            hash = (hash ^ Ip.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getServer("192.1 68.12.13" + i));
        }
        System.out.println("-----------------------------------");
        for (int i = 1; i <= 3; i++) {
            System.out.println(getServer("192.168.12.131"));
        }
    }
}

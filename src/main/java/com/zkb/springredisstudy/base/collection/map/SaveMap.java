package com.zkb.springredisstudy.base.collection.map;

import java.util.concurrent.ConcurrentHashMap;

public class SaveMap {
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("cpu cores is " + processors);
        System.out.println((16 > 1) ? ((1 << 30) >>> 3) / 16 : 32);
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1, 1);
    }
}

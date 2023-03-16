package com.zkb.springredisstudy.algorithm.distributeserver;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static com.zkb.springredisstudy.algorithm.distributeserver.Servers.SERVERS;

public class ServerNodeChoose {



    private static AtomicInteger serverIndex = new AtomicInteger(0);


    public static String roundGetServer() {
        int index = serverIndex.getAndIncrement() % SERVERS.size();
        String server = SERVERS.get(index);
        return server;
    }

    public static String randomGetServer() {
        int index = ThreadLocalRandom.current().nextInt(SERVERS.size());
        String s = SERVERS.get(index);
        return s;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            System.out.println(roundGetServer());
            System.out.println(randomGetServer());
        }
    }
}

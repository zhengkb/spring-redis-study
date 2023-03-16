package com.zkb.springredisstudy.algorithm.currlimit;

import java.util.concurrent.TimeUnit;

public class TokenBucketTest {

    public static void main(String[] args) {
        TokenBucket tokenBucket = new TokenBucket(1500000, 1, TimeUnit.SECONDS);
        new Thread(() -> {
            try {
                tokenBucket.addToken();
            } catch (NumValidException e) {
                throw new RuntimeException(e);
            }
        }).start();

        for (int i = 0; i < 20; i++) {
            int num = i;
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(20 + num * 3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                tokenBucket.getToken();
            }).start();
        }

    }
}

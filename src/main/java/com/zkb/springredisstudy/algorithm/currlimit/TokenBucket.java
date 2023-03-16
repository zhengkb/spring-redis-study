package com.zkb.springredisstudy.algorithm.currlimit;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


public class TokenBucket {

    private long tokenNum;

    private long rate;

    private TimeUnit timeUnit;

    private static long hasTokenNum = 0;

    private static final ReentrantLock lock = new ReentrantLock();

    public TokenBucket(int tokenNum, long rate, TimeUnit timeUnit) {
        this.tokenNum = tokenNum;
        this.rate = rate;
        this.timeUnit = timeUnit;
    }

    public void addToken() throws NumValidException {
        if (tokenNum <= 0) {
            throw new NumValidException();
        }

        long duration = timeUnit.toMillis(rate);
        long timeMillis = System.currentTimeMillis();

        for (; ; ) {
            long millis = System.currentTimeMillis();
            if (millis - timeMillis < duration) {
                continue;
            }
            timeMillis = System.currentTimeMillis();
            if (hasTokenNum >= tokenNum) {
                System.out.println("已达到最大令牌数：：：" + hasTokenNum);
                continue;
            }
            try {
                lock.lock();
                hasTokenNum++;
                System.out.println("令牌补充开始：：：：" + hasTokenNum);
            } finally {
                lock.unlock();
            }
        }
    }

    public boolean getToken() {
        try {
            lock.lock();
            if (hasTokenNum <= 0) {
                System.out.println("获取令牌失败，令牌数量为：：：" + hasTokenNum);
                return false;
            }
            hasTokenNum--;
            System.out.println("获取令牌成功：：：" + hasTokenNum);
            return true;
        } finally {
            lock.unlock();
        }
    }

}

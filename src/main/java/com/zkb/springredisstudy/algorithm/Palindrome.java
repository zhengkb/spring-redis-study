package com.zkb.springredisstudy.algorithm;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    /**
     * 121
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        int reserved = 0;
        int tmp = x;
        while (x > 0) {
            reserved = reserved * 10 + x % 10;
            x /= 10;
        }
        System.out.println(reserved);
        return reserved == tmp;
    }
}

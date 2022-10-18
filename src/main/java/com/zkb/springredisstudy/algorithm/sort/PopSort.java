package com.zkb.springredisstudy.algorithm.sort;

public class PopSort {

    public static void solution(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}

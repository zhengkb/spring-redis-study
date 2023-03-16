package com.zkb.springredisstudy.algorithm.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class DynamicPlan {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
//        System.out.println(climbStairs(3));
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }

        if (n <= 2) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            map.put(n, climbStairs(n - 1) + climbStairs(n - 2));
            return map.get(n);
        }

    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] arr = new int[nums.length];
        arr[0] = 1;
        int maxSize = 1;

        for (int i = 1; i < nums.length; i++) {
            arr[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
            maxSize = Math.max(maxSize, arr[i]);
        }
        return maxSize;
    }
}

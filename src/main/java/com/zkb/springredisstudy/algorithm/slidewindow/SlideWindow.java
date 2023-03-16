package com.zkb.springredisstudy.algorithm.slidewindow;

import java.util.*;

public class SlideWindow {

//    public static int getMaxLen(String str) {
//        int len = str.length();
//        Set<Character> set = new HashSet<>();
//        int left = 0, right = 0;
//        int res = 0;
//        while (right < len) {
//            char charAt = str.charAt(right);
//            right++;
//            while (set.contains(charAt)) {
//                set.remove(str.charAt(left));
//                left++;
//            }
//
//    }

    public static void main(String[] args) {
//        int[] arr = {100, 200, 300, 400};
//        int maxNum = getMaxNum(arr, 2);
//        System.out.println(maxNum);
//        System.out.println(getMaxLen("abcdabcaa"));
        System.out.println(minStr2("ADOBECODEBANC", "ABC"));
    }

    public static String minStr2(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            window.put(s.charAt(i), 0);
        }


        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (window.containsKey(c)) {
                window.put(c, window.get(c) + 1);
            } else {
                return "";
            }
        }

        String res = "";
        int left = 0, right = 0;
        int minSize = Integer.MAX_VALUE;
        int count = t.length();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (window.get(c) > 0) count--;
            window.put(c, window.get(c) - 1);
            right++;

            while (count == 0) {

                if (right - left < minSize) {
                    minSize = right - left;
                    res = s.substring(left, right);
                }

                char c2 = s.charAt(left);
                if (window.get(c2) == 0) count++;
                window.put(c2, window.get(c2) + 1);
                left++;
            }
        }
        return res;
    }

    public static String minStr(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), 0);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                return "";
            }
        }

        int right = 0, left = 0;
        int minSize = Integer.MAX_VALUE;
        int count = t.length();
        String result = "";

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.get(c) > 0) {
                count--;
            }
            map.put(c, map.get(c) - 1);
            right++;

            while (count == 0) {
                if (minSize > right - left) {
                    minSize = right - left;
                    result = s.substring(left, right);
                }
                char c2 = s.charAt(left);
                if (map.get(c2) == 0) {
                    count++;
                }
                map.put(c2, map.get(c2) + 1);
                left++;
            }
        }
        return result;
    }

    public static int getMaxLen(String str) {
        int len = str.length();
        Set<Character> window = new HashSet<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < len) {
            char charAt = str.charAt(right);
            right++;
            while (window.contains(charAt)) {
                window.remove(str.charAt(left));
                left++;
            }
            window.add(charAt);
            res = Math.max(res, window.size());
        }
        return res;
    }


    public static int getMaxNum(int[] arr, int k) {
        if (arr.length < k) {
            return 0;
        }

        int maxNum = 0;
        for (int i = 0; i < k; i++) {
            maxNum += arr[i];
        }

        int num = maxNum;
        for (int i = k; i < arr.length; i++) {
            num = maxNum + arr[i] - arr[i - k];
            maxNum = Math.max(num, maxNum);
        }

        return maxNum;
    }
}

package com.zkb.springredisstudy.algorithm.slidewindow;

import java.util.*;

public class SlideWindow2 {

    public static void main(String[] args) {
//        System.out.println(minStr("abcabcbb"));
//        int[] arr = {99, 99};
//        System.out.println(containsNearbyDuplicate(arr, 2));
//        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
//        int[] arr = {2, 3, 1, 2, 4, 3};

//        System.out.println(minSubArrayLen(7, arr));

//        int[] nums = {0, 4, 0, 3, 2};
//        System.out.println(findMaxAverage(nums, 1));

//        System.out.println(checkInclusion("ab", "eedbaooo"));
//        int[] arr = {10, 5, 2, 6};
//        System.out.println(numSubarrayProductLessThanK(arr, 100));

//        int[] arr = {10, 1, 2, 4, 7, 2};
//        System.out.println(longestSubarray(arr, 5));

//        int[] arr = {0, 1, 1, 1, 0, 1, 1, 0, 1};
//        System.out.println(longestSubarray(arr));

//        int[] arr = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
//        System.out.println(numOfSubArrays(arr, 3, 5));


//        System.out.println(findAnagrams("abab", "ab"));

//        int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
//        System.out.println(totalFruit(arr));

//        System.out.println(countGoodSubstrings("aababcabc"));

//        System.out.println(divisorSubstrings(240, 2));

//        System.out.println(takeCharacters("abc", 2));

//        int[] arr = {1, 2, 3, 2};
//        System.out.println(beautifulBouquet(arr, 1));

//        System.out.println(lengthOfLongestSubstring("pwwkew"));

//        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        int[] arr = {1,0,1,1};
        System.out.println(containsNearbyAlmostDuplicate(arr, 1, 2));
    }


    public static int minStr(String str) {
        if (str == null || str.equals("")) {
            return -1;
        }


        int left = 0, right = 0;
        int minSize = 0;
        Set<Character> set = new HashSet<>();
        while (right < str.length()) {
            char c = str.charAt(right);
            while (set.contains(c)) {
                set.remove(str.charAt(left));
                left++;
            }
            set.add(c);
            right++;
            minSize = Math.max(minSize, set.size());
        }
        return minSize;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0, right = 0;

        Set<Integer> set = new HashSet<>();

        while (right < nums.length) {

            if (right - left > k) {
                set.remove(nums[left]);
                left++;
            }
            //外层移动right,内层移动left
            if (set.contains(nums[right])) {
                return true;
            }
            set.add(nums[right]);
            right++;
        }
        return false;
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String s1 = s.substring(i, i + 10);
            map.put(s1, map.getOrDefault(s1, 0) + 1);

            if (map.get(s1) == 2) {
                list.add(s1);
            }
        }
        return list;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        int left = 0, right = 0;

        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minSize = Math.min(right - left + 1, minSize);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }


    public static double findMaxAverage(int[] nums, int k) {
//        int left = 0, right = 0;
//        double maxAverage = -Double.MAX_VALUE;
//        double sum = 0;
//        while (right < nums.length) {
//            sum += nums[right];
//            while (right - left == k - 1) {
//                maxAverage = Math.max(maxAverage, sum / k);
//                sum -= nums[left];
//                left++;
//            }
//            right++;
//        }
//        return maxAverage;

        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }


    public static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;


        int size = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxSize = getMaxLength(nums1, nums2, i, 0, len);
            size = Math.max(maxSize, size);
        }

        for (int i = 0; i < m; i++) {
            int len = Math.min(m - i, n);
            int maxSize = getMaxLength(nums1, nums2, 0, i, len);
            size = Math.max(maxSize, size);
        }
        return size;
    }

    public static int getMaxLength(int[] arr1, int[] arr2, int left, int right, int len) {

        int k = 0;
        int maxSize = 0;
        for (int i = 0; i < len; i++) {
            if (arr1[i + left] == arr2[i + right]) {
                k++;
            } else {
                k = 0;
            }
            maxSize = Math.max(maxSize, k);
        }
        return maxSize;
    }


    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int prod = 1, ret = 0;

        while (right < nums.length) {
            prod *= nums[right];

            while (left <= right && prod >= k) {
                prod /= nums[left];
                left++;
            }
            ret += right - left + 1;
            right++;
        }
        return ret;
    }

    /**
     * 解题思路：
     * 利用有序集合，获取范围内最大和最小的值，比对其差值是否大于所对应的结果
     * 如果大于，那么移动左侧标记，删除对应元素
     * 如果满足条件那么输出，比对范围大小，选出最大的
     *
     * @param nums
     * @param limit
     * @return
     */
    public static int longestSubarray(int[] nums, int limit) {
        int left = 0, right = 0, maxSize = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            maxSize = Math.max(maxSize, right - left + 1);
            right++;
        }
        return maxSize;
    }

    /**
     * 基于滑动窗口解决这个问题
     * 移动右侧向窗口内添加元素
     * 进行判断，判断窗口内的元素是否满足只有一个不是1
     * 如果满足条件，那么右侧继续移动
     * 如果不满足，那么需要移动左侧，从左侧删除元素，直到满足窗口内只有一个不是1
     *
     * @param nums
     * @return
     */
    public static int longestSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxSize = 0;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.getOrDefault(1, 0) < right - left) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            maxSize = Math.max(maxSize, right - left);
            right++;
        }
        return maxSize;
    }

    public static int maxScore(int[] cardPoints, int k) {
        int maxNum = 0;
        int len = cardPoints.length;

        for (int i = 0; i < k; i++) {
            maxNum += cardPoints[i];
        }

        int m = maxNum;

        for (int i = 0; i < k; i++) {
            m += cardPoints[len - i - 1];
            m -= cardPoints[k - i - 1];
            maxNum = Math.max(maxNum, m);
        }
        return maxNum;
    }

    public static int numOfSubArrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int times = 0;
        if (sum >= threshold * k) {
            times++;
        }

        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i - k];
            if (sum >= threshold * k) {
                times++;
            }
        }
        return times;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();

        if (n > m) {
            return Collections.emptyList();
        }

        List<Integer> list = new ArrayList<>();

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < n; i++) {
            ++arr1[s.charAt(i) - 'a'];
            ++arr2[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(arr1, arr2)) {
            list.add(0);
        }

        for (int i = n; i < m; i++) {
            --arr1[s.charAt(i - n) - 'a'];
            ++arr1[s.charAt(i) - 'a'];
            if (Arrays.equals(arr1, arr2)) {
                list.add(i - n + 1);
            }
        }
        return list;

    }

    public static int totalFruit(int[] fruits) {
        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxSize = 0;
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                int num = fruits[left];
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
                left++;
            }
            maxSize = Math.max(maxSize, right - left + 1);
            right++;
        }
        return maxSize;
    }


    public static int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int nums = 0;

        for (int i = 0; i < 3; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (map.size() == 3) {
            nums++;
        }

        for (int i = 3; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            char c = s.charAt(i - 3);
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
            if (map.size() == 3) {
                nums++;
            }
        }
        return nums;
    }

    public static int divisorSubstrings(int num, int k) {
        String str = num + "";

        int size = 0;

        int number = 0;
        String substring = str.substring(0, k);
        number = Integer.parseInt(substring);

        if (number != 0 && num % number == 0) {
            size++;
        }

        for (int i = k; i < str.length(); i++) {
            char c = str.charAt(i);
            substring = substring.substring(1);
            substring += c;
            number = Integer.parseInt(substring);
            if (number != 0 && num % number == 0) {
                size++;
            }
        }
        return size;
    }

    public static int takeCharacters(String s, int k) {
        int minSize = Integer.MAX_VALUE, left = 0, right = 0;

        int[] arr1 = new int[3];
        for (int i = 0; i < s.length(); i++) {
            ++arr1[s.charAt(i) - 'a'];
        }

        if (s.length() == 3 * k && arr1[1] == k && arr1[0] == k && arr1[2] == k) {
            return s.length();
        }

        int[] arr2 = new int[3];

        while (right < s.length()) {
            ++arr2[s.charAt(right) - 'a'];

            while (left < right && (arr1[0] - arr2[0] < k || arr1[1] - arr2[1] < k || arr1[2] - arr2[2] < k)) {
                --arr2[s.charAt(left) - 'a'];
                left++;
            }

            if (arr1[0] - arr2[0] >= k && arr1[1] - arr2[1] >= k && arr1[2] - arr2[2] >= k) {
                int sum = arr2[0] + arr2[1] + arr2[2];
                minSize = Math.min(minSize, s.length() - sum);
            }
            right++;
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    public static int beautifulBouquet(int[] flowers, int cnt) {
        int left = 0, right = 0;
        int[] arr = new int[(int) 1e5 + 1];

        long res = 0;

        while (right < flowers.length) {
            int flower = flowers[right];
            ++arr[flower];

            while (arr[flowers[right]] > cnt) {
                --arr[flowers[left]];
                left++;
            }
            res += right - left + 1;
            res %= (int) 1e9 + 7;
            right++;
        }
        return (int) res;
    }

    public static boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();

        if (m > n) {
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < m; i++) {
            ++arr1[s1.charAt(i) - 'a'];
            ++arr2[s2.charAt(i) - 'a'];
        }

        if (Arrays.equals(arr1, arr2)) {
            return true;
        }

        for (int i = m; i < n; i++) {
            ++arr2[s2.charAt(i) - 'a'];
            --arr2[s2.charAt(i - m) - 'a'];
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }
        return false;
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();

        if (s.equals("")) {
            return 0;
        }

        int maxSize = 0;

        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.get(s.charAt(right)) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            maxSize = Math.max(maxSize, right - left + 1);
            right++;
        }
        return maxSize;
    }

    public static String minWindow(String s, String t) {
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int minSize = Integer.MAX_VALUE;
        String str = "";

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
        int count = t.length();

        while (right < s.length()) {
            if (map.get(s.charAt(right)) > 0) {
                count--;
            }
            map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
            right++;

            while (count == 0) {
                if (minSize > right - left) {
                    minSize = right - left;
                    str = s.substring(left, right);
                }
                char c = s.charAt(left);
                if (map.get(c) == 0) {
                    count++;
                }
                map.put(c, map.get(c) + 1);

                left++;
            }

        }
        return str;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);

            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}

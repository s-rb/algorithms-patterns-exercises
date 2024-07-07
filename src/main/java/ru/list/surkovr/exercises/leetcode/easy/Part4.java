package ru.list.surkovr.exercises.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Part4 {

    public static void main(String[] args) {
        System.out.println(numOfSubarrays2(new int[]{2,2,2,2,5,5,5,8}, 3, 4));
    }

    public static int minTimeToType(String word) {
        if (word.length() == 1) return 1;
        int from = (int) 'a';
        int to = (int) 'z';
        int pointer = from;
        int count = 0;
        for (char c : word.toCharArray()) {
            if ((int) c != pointer)
            {
                int clockwise = ((int) c) > pointer ? ((int) c) - pointer : (to - pointer) + ((int) c - from) + 1;
                int counter = ((int) c) < pointer ? (pointer - (int) c) : (pointer - from) + (to - (int) c) + 1;
                count += Math.min(clockwise, counter);
            }
            count++;
            pointer = (int) c;
        }
        return count;
    }

    public static int findMiddleIndex(int[] nums) {
        int index = 0;
        int right = 0;
        for (int i = 1; i < nums.length; i++) right += nums[i];
        int left = 0;
        while (right != left && index < nums.length - 1) {
            left += nums[index];
            index++;
            right = index == nums.length - 1 ? 0 : right - nums[index];
        }
        return right == left ? index : -1;
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] arr = s.split("\\s+");
        if (pattern.length() != arr.length) return false;

        Map<Character, String> map = new HashMap<>();
        char[] chars = pattern.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            String w = arr[i];
            if (map.isEmpty() || (!map.containsKey(c) && !map.containsValue(w))) {
                map.put(c, w);
            } else if (map.containsKey(c)) {
                String existed = map.get(c);
                if (!existed.equals(w)) return false;
            } else return false;
        }
        return true;
    }

    public static boolean isPowerOfThree(int n) {
        long max = 1;
        int pow = 0;
        while (true) {
            if (max >= Integer.MAX_VALUE) break;
            pow += 1;
            max = (long) Math.pow(3, pow+1);
        }
        return ((int) (max / 3)) % 3 == 0;
    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) sum += arr[j];
            if (sum / k >= threshold) count++;
        }
        return count;
    }

    public static int numOfSubarrays2(int[] arr, int k, int threshold) {
        int count = 0;
        int n = k * threshold;
        int window = 0;
        for (int i = 0; i < k; i++) {
            window += arr[i];
        }
        if (window >= n) count++;

        for (int i = 1; i <= arr.length - k; i++) {
            window = window - arr[i-1] + arr[i+k-1];
            if (window >= n) count++;
        }
        return count;
    }

    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        s = s.replaceFirst("6", "9");
        return Integer.parseInt(s);
    }
}

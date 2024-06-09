package ru.list.surkovr.data_structures.prefix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrefixSum {

    /**
     * 2574. Left and Right Sum Differences
     * Easy
     * Topics
     * Companies
     * Hint
     * Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:
     *
     * answer.length == nums.length.
     * answer[i] = |leftSum[i] - rightSum[i]|.
     * Where:
     *
     * leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
     * rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
     * Return the array answer.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [10,4,8,3]
     * Output: [15,1,11,22]
     * Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
     * The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].
     * Example 2:
     *
     * Input: nums = [1]
     * Output: [0]
     * Explanation: The array leftSum is [0] and the array rightSum is [0].
     * The array answer is [|0 - 0|] = [0].
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 1000
     * 1 <= nums[i] <= 105
     */
    public static int[] leftRightDifference(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int leftSum = getLeftSum(nums, i);
            int rightSum = getRightSum(nums, i);
            res[i] = Math.abs(leftSum - rightSum);
        }
        return res;
    }

    private static int getLeftSum(int[] nums, int i) {
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += nums[j];
        }
        return sum;
    }

    private static int getRightSum(int[] nums, int i) {
        int sum = 0;
        for (int j = nums.length-1; j > i; j--) {
            sum += nums[j];
        }
        return sum;
    }

    public static int[] leftRightDifference2(int[] nums) {
        int[] res = new int[nums.length];
        int leftSum = 0;
        int rightSum = 0;
        for (int j = 1; j < nums.length; j++) rightSum += nums[j];
        res[0] = Math.abs(leftSum - rightSum);

        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i-1];
            rightSum = rightSum - (i < nums.length ? nums[i] : 0);
            res[i] = Math.abs(leftSum - rightSum);
        }
        return res;
    }

    /**
     * 2391. Minimum Amount of Time to Collect Garbage
     * Medium
     * Topics
     * Companies
     * Hint
     * You are given a 0-indexed array of strings garbage where garbage[i] represents the assortment of garbage at the ith house. garbage[i] consists only of the characters 'M', 'P' and 'G' representing one unit of metal, paper and glass garbage respectively. Picking up one unit of any type of garbage takes 1 minute.
     *
     * You are also given a 0-indexed integer array travel where travel[i] is the number of minutes needed to go from house i to house i + 1.
     *
     * There are three garbage trucks in the city, each responsible for picking up one type of garbage. Each garbage truck starts at house 0 and must visit each house in order; however, they do not need to visit every house.
     *
     * Only one garbage truck may be used at any given moment. While one truck is driving or picking up garbage, the other two trucks cannot do anything.
     *
     * Return the minimum number of minutes needed to pick up all the garbage.
     *
     *
     *
     * Example 1:
     *
     * Input: garbage = ["G","P","GP","GG"], travel = [2,4,3]
     * Output: 21
     * Explanation:
     * The paper garbage truck:
     * 1. Travels from house 0 to house 1
     * 2. Collects the paper garbage at house 1
     * 3. Travels from house 1 to house 2
     * 4. Collects the paper garbage at house 2
     * Altogether, it takes 8 minutes to pick up all the paper garbage.
     * The glass garbage truck:
     * 1. Collects the glass garbage at house 0
     * 2. Travels from house 0 to house 1
     * 3. Travels from house 1 to house 2
     * 4. Collects the glass garbage at house 2
     * 5. Travels from house 2 to house 3
     * 6. Collects the glass garbage at house 3
     * Altogether, it takes 13 minutes to pick up all the glass garbage.
     * Since there is no metal garbage, we do not need to consider the metal garbage truck.
     * Therefore, it takes a total of 8 + 13 = 21 minutes to collect all the garbage.
     * Example 2:
     *
     * Input: garbage = ["MMM","PGM","GP"], travel = [3,10]
     * Output: 37
     * Explanation:
     * The metal garbage truck takes 7 minutes to pick up all the metal garbage.
     * The paper garbage truck takes 15 minutes to pick up all the paper garbage.
     * The glass garbage truck takes 15 minutes to pick up all the glass garbage.
     * It takes a total of 7 + 15 + 15 = 37 minutes to collect all the garbage.
     *
     *
     * Constraints:
     *
     * 2 <= garbage.length <= 105
     * garbage[i] consists of only the letters 'M', 'P', and 'G'.
     * 1 <= garbage[i].length <= 10
     * travel.length == garbage.length - 1
     * 1 <= travel[i] <= 100
     */
    public static int garbageCollection(String[] garbage, int[] travel) {
        int travelSum = 0;
        for (int i : travel) travelSum += i;
        Map<Character, Integer> collectorAndLastHouse = new HashMap<>();
        Map<Character, Integer> travels = new HashMap<>();
        for (int house = 0; house < garbage.length; house++) {
            String g = garbage[house];
            for (Character c : g.toCharArray()) {
                collectorAndLastHouse.put(c, house);
                travels.put(c, travels.getOrDefault(c, 0)+1);
            }
        }
        for (Map.Entry<Character, Integer> entry : travels.entrySet()) {
            Character c = entry.getKey();
            Integer lastHouse = collectorAndLastHouse.get(c);
            if (lastHouse == null) continue;
            int currentTravel = travelSum;
            for (int j = travel.length-1; j >= lastHouse; j--) currentTravel = currentTravel - travel[j];
            travels.put(c, travels.get(c)+currentTravel);
        }
        return travels.values().stream().reduce((o1,o2) -> o1 + o2).get();
    }

    public static int garbageCollection2(String[] garbage, int[] travel) {
        int res = 0;
        for (String g : garbage) res += g.length();
        for (int t : travel) res += 3*t;
        var list = new char[]{'G', 'P', 'M'};
        for (char ch : list) res = reduceRes(garbage, travel, ch, res);
        return res;
    }

    private static int reduceRes(String[] garbage, int[] travel, char ch, int res) {
        for (int j = garbage.length-1; j > 0; j--) {
            if (garbage[j].indexOf(ch) < 0) {
                res -= travel[j-1];
            } else break;
        }
        return res;
    }
}

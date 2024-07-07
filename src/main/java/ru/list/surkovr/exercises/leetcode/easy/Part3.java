package ru.list.surkovr.exercises.leetcode.easy;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Part3 {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{1, 2, 3, 4}));
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && i < nums.length - 1) {
                int next = i + 1;
                while (next < nums.length - 1 && nums[next] == 0) next++;
                nums[i] = nums[next];
                nums[next] = 0;
            }
        }
    }

    public static long smallestNumber(long num) {
        if (Math.abs(num) < 10) return num;
        boolean isNegative = num < 0;
        String str = String.valueOf(num).replace("-", "");
        Character[] nums = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            nums[i] = str.charAt(i);
        }

        Arrays.sort(nums, isNegative ? Comparator.reverseOrder() : Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder(isNegative ? "-" : "");
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            char current = nums[i];
            if (current == '0') {
                zeros++;
                continue;
            }
            if (!isNegative && ((int) current > (int) '0') && sb.length() > 0) {
                while (zeros-- > 0) sb.append('0');
            }
            sb.append(current);
        }

        while (zeros-- > 0) sb.append('0');
        return Long.parseLong(sb.toString());
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int from = 2;
        int to = x / 2;
        int num = to;
        int sqr = num * num;
        while (sqr != x) {
            if (sqr > x) {
                to = num;
            } else if (sqr < x) {
                from = num;
            }
            num = Math.round(((float) to - from) / 2);
            sqr = num * num;
        }
        return num;
    }

    public static int nextGreaterElement(int n) {
        if (n / 10 == 0) return -1;
        List<Integer> ints = new ArrayList<>();
        int temp = n;
        while (temp / 10 > 0) {
            ints.add(temp % 10);
            temp /= 10;
        }
        ints.add(temp);

        // с конца находим элемент, который меньше чем слеующий - 12543 - 2
        int left = 1;
        while (left < ints.size() && ints.get(left) >= ints.get(left - 1)) left++;

        if (left == ints.size()) return -1;

        int right = 0;
        while ((right < left) && ints.get(right) <= ints.get(left)) right++;

        swapItems(ints, left, right);
        reverse(ints, left - 1, 0);
        reverse(ints);

        long res = Long.parseLong(ints.stream().map(String::valueOf).collect(Collectors.joining()));
        return res <= Integer.MAX_VALUE ? (int) res : -1;
    }

    private static void swapItems(List<Integer> ints, int left, int right) {
        int temp = ints.get(left);
        ints.set(left, ints.get(right));
        ints.set(right, temp);
    }

    private static void reverse(List<Integer> ints) {
        for (int i = 0; i < ints.size() / 2; i++) {
            swapItems(ints, i, ints.size() - i - 1);
        }
    }

    private static void reverse(List<Integer> ints, int from, int to) {
        for (int i = 0; i <= (from + to) / 2; i++) {
            swapItems(ints, from - i, to + i);
        }
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int start = 0; start < len; start++) {
            int sum = nums[start];
            if (sum == k) count++;
            for (int end = start + 1; start < len - 1 && end < len; end++) {
                sum += nums[end];
                if (sum == k) count++;
            }
        }
        return count;
    }

    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int len = cost.length;
        int i = len - 1;
        int res = 0;
        while (i >= 0) {
            int first = cost[i--];
            System.out.println("first: " + first);
            int second;
            if (i >= 0) {
                second = cost[i--];
            } else second = 0;
            System.out.println("second: " + second + ", i: " + i);
            int temp = first + second;
            res += temp;
            if (i > 0) i--;
            i--;
        }
        return res;
    }

    public static boolean digitCount(String num) {
        for (int i = 0; i < num.length(); i++) {
            String val = String.valueOf(i);
            String temp = "_" + num + "_";
            int cur = Integer.parseInt("" + num.charAt(i));
            if ((!num.contains(val) && cur != 0) || temp.split(val).length != cur + 1) return false;
        }
        return true;
    }

    public static String[] findWords(String[] words) {
        Set<String> rows = Set.of(
                "qwertyuiop".chars().mapToObj(o -> (char) o).sorted().map(o -> new StringBuilder().append(o))
                        .reduce(StringBuilder::append).map(StringBuilder::toString).get(),
                "asdfghjkl".chars().mapToObj(o -> (char) o).sorted().map(o -> new StringBuilder().append(o)).collect(Collectors.joining()),
                "zxcvbnm".chars().mapToObj(o -> (char) o).sorted().map(o -> new StringBuilder().append(o)).collect(Collectors.joining())
        );
        return Arrays.stream(words).filter(word ->
                rows.stream().anyMatch(row -> {
                    String syms = word.toLowerCase().chars().mapToObj(o -> (char) o).sorted().distinct()
                            .map(o -> new StringBuilder().append(o)).collect(Collectors.joining());
                    return row.contains(syms);
                }))
                .toArray(String[]::new);
    }

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        fillFreq(map, root);
        int maxVal = map.values().stream()
                .max(Comparator.naturalOrder()).get();
        List<Integer> list = map.entrySet().stream()
                .filter(o -> o.getValue().equals(maxVal))
                .map(o -> o.getKey())
                .collect(Collectors.toList());
        int [] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }

    private void fillFreq(Map<Integer, Integer> map, TreeNode tree) {
        map.put(tree.val, map.getOrDefault(tree.val, 0)+1);
        if (tree.right == null && tree.left == null) return;
        fillFreq(map, tree.right);
        fillFreq(map, tree.left);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = Arrays.stream(stones).boxed()
                .collect(Collectors.toCollection(new Supplier<>() {
                    @Override
                    public PriorityQueue<Integer> get() {
                        return new PriorityQueue<>(Comparator.reverseOrder());
                    }
                }));
        while (queue.size() > 1) {
            Integer x = queue.poll();
            Integer y = queue.poll();
            if (x == y) continue;
            queue.add(Math.abs(x - y));
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}